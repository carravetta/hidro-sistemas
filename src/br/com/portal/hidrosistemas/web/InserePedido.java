package br.com.portal.hidrosistemas.web;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.portal.hidrosistemas.control.Empresa;
import br.com.portal.hidrosistemas.control.Produto;
import br.com.portal.hidrosistemas.db.ConnectionPool;
import br.com.portal.hidrosistemas.db.ItensDePedidoDAO;
import br.com.portal.hidrosistemas.db.PedidoDAO;
import br.com.portal.hidrosistemas.db.ProdutoDAO;
import br.com.portal.hidrosistemas.output.EnviaEmail;
import br.com.portal.hidrosistemas.output.WriteXLS;

public class InserePedido implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();
		Empresa usuario = (Empresa) session.getAttribute("usuarioLogado");
		session.removeAttribute("itemInvalido");
			
		if (usuario != null) {

			try (Connection con = new ConnectionPool().getConnetion()) {

				String[] descricao = req.getParameterValues("desc");
				String[] quantidade = req.getParameterValues("qnt");
				ArrayList<Boolean> verifica = new ArrayList<>();

				List<Produto> listaProdutos = new JsonWrite(con).listaProdutos();

				for (int i = 0; i < descricao.length; i++) {
					for (Produto item : listaProdutos) {
						if (item.getDescricao().equals(descricao[i])) {
							verifica.add(true);
							break;
						}
					}
				}
				if (descricao.length != verifica.size()) {
					session.setAttribute("itemInvalido", "Item invalido, favor verifique");
					return "/WEB-INF/paginas/pedidos.jsp";					
				} 
				
				long idPedido = new PedidoDAO(con).inserePedido(usuario.getId());

				for (int i = 0; i < descricao.length; i++) {
					if (descricao[i] != "") {
						String codigo = getCodigoItem(descricao[i]);
						String unidade = getUnidadeItem(descricao[i]);
						new ItensDePedidoDAO(con).insereItensNoPedido(descricao[i], Integer.parseInt(quantidade[i]),
								unidade, idPedido, codigo);
					}

				}

				new WriteXLS().escrevePedidoXLS(usuario, descricao, quantidade, idPedido);

				new EnviaEmail().enviaEmailPedido("lscarravetta@gmail.com", toStringPedido(req),
						"HIDRO SISTEMAS PEDIDO: " + idPedido, idPedido);

			}
			session.setAttribute("pedidoEnviado", "Pedido enviado com sucesso");
			return "/WEB-INF/paginas/pedidos.jsp";
		}

		return "/index.jsp"; // caso usuario == null

	}

	private String toStringPedido(HttpServletRequest req) {

		HttpSession session = req.getSession();
		Empresa usuario = (Empresa) session.getAttribute("usuarioLogado");

		String[] descricao = req.getParameterValues("desc");
		String[] quantidade = req.getParameterValues("qnt");
		String itens = null;
		String retorno = "";
		try {
			for (int i = 0; i < descricao.length; i++) {
				if (descricao[i] != "") {
					itens = descricao[i] + " " + getUnidadeItem(descricao[i]) + "   " + quantidade[i] + "\n";
					retorno += itens;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario.toString() + "\n" + retorno;
	}

	public String getUnidadeItem(String descricaoItem) throws Exception {
		try (Connection con = new ConnectionPool().getConnetion()) {

			List<Produto> produtos = new JsonWrite(con).listaProdutos();
			for (Produto prod : produtos) {
				if (prod.getDescricao().equals(descricaoItem))
					return prod.getUnidade();
			}
		}

		return null;
	}

	public String getCodigoItem(String descricao) throws Exception {

		try (Connection con = new ConnectionPool().getConnetion()) {
			List<Produto> produto = new ProdutoDAO(con).listaProdutos();

			for (Produto prod : produto) {

				if (prod.getDescricao().equals(descricao))
					return prod.getCodigo();
			}

		}

		return null;
	}

}
