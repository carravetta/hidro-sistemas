package br.com.portal.hidrosistemas.web;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.portal.hidrosistemas.db.ConnectionPool;
import br.com.portal.hidrosistemas.db.ItensDePedidoDAO;
import br.com.portal.hidrosistemas.db.PedidoDAO;
import br.com.portal.hidrosistemas.model.Empresa;
import br.com.portal.hidrosistemas.model.ItensPedido;
import br.com.portal.hidrosistemas.model.Pedido;
import br.com.portal.hidrosistemas.model.Produto;
import br.com.portal.hidrosistemas.output.EnviaEmail;
import br.com.portal.hidrosistemas.output.WriteXLS;

public class EnviaPedido implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		HttpSession session = req.getSession();
		Empresa usuario = (Empresa) session.getAttribute("usuarioLogado");
		
		if(session.getAttribute("pedidoEnviado") != null) {
			return "/WEB-INF/paginas/verificacao.jsp";
		
		}
		
		
		String quantidadeDoItem[] = req.getParameterValues("qnt");
		List<Produto> carrinhoCompras = new ArrayList<>();
		carrinhoCompras = (ArrayList<Produto>) session.getAttribute("carrinho");
		
		if(carrinhoCompras.isEmpty() == false) {
			try (Connection con = new ConnectionPool().getConnetion()) {
				Pedido pedido = new PedidoDAO(con).inserePedido(usuario.getId());
				int cont = 0;
				for(Produto produto : carrinhoCompras) {
					
					new ItensDePedidoDAO(con).insereItensNoPedido(produto, Integer.parseInt(quantidadeDoItem[cont]) , pedido.getId());	
					cont++;
				}
				long idPedido = pedido.getId();
				new WriteXLS().escrevePedidoXLS(usuario, new ItensDePedidoDAO(con).buscaPedido(idPedido), idPedido );
				new EnviaEmail().enviaEmailPedido("lscarravetta@gmail.com", msgEmailConfimacao(),
					"HIDRO SISTEMAS PEDIDO: " + idPedido , idPedido);
			}
		}
		
		carrinhoCompras = null;
		session.setAttribute("carrinho", carrinhoCompras);
		session.setAttribute("pedidoEnviado", "Pedido enviado com sucesso!");
		
		
		return "/WEB-INF/paginas/verificacao.jsp";
	}
	
	
	public String msgEmailConfimacao() {

		return "Segue pedido em anexo.\n\n" + "Para confirmar este pedido encaminnhar este e-mail junto com o anexo "
				+ "para o seu vendedor que nos lê em cópia (irpcanoas@hidrosistemas.com)\n\n\n"
				+ "Este é um e-mail gerado automaticamente, favor não respoder.";

	}

}
