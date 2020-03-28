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
import br.com.portal.hidrosistemas.db.ProdutoDAO;
import br.com.portal.hidrosistemas.model.Empresa;
import br.com.portal.hidrosistemas.model.Produto;
import br.com.portal.hidrosistemas.output.EnviaEmail;
import br.com.portal.hidrosistemas.output.WriteXLS;

public class Principal implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();
		Connection con = new ConnectionPool().getConnetion();
		Empresa usuario = (Empresa) session.getAttribute("usuarioLogado");
		
		session.getAttribute("carrinho");
		session.setAttribute("pedidoEnviado", null);
		session.setAttribute("pesquisaProduto", null);
		session.setAttribute("pesquisa", null);
		session.setAttribute("ultimaPagina", 1);
		
		double totalProdutos = new ProdutoDAO(con).totalProdutos();
		totalProdutos = Math.ceil(totalProdutos / 30);
		session.setAttribute("totalProduto", totalProdutos);
		
		if (usuario != null ) {
			
			String numPagina = req.getParameter("pagina");
			List<Produto> listaProdutos = null;			
			try (Connection con2 = new ConnectionPool().getConnetion()) {
				if(numPagina == null) {
					listaProdutos = new ProdutoDAO(con2).listaProdutos(0);
					session.setAttribute("listaProdutos", listaProdutos);
				}
				else {
					int offset = (Integer.parseInt(numPagina) * 30) - 30; //30 = limite de paginas;
					listaProdutos = new ProdutoDAO(con2).listaProdutos(offset);
					session.setAttribute("listaProdutos", listaProdutos);
					session.setAttribute("ultimaPagina", Integer.parseInt(numPagina) ); //salva a ultima pagina visitada 
				}
			}
		}
		
		String qnt = req.getParameter("qnt");
		if(qnt != null) {
			List<Produto> carrinho = (ArrayList<Produto>)session.getAttribute("carrinho");
			Produto ultimoItem = (Produto) session.getAttribute("ultimoItem");
			
			
			for(Produto item : carrinho) {
				if(item.getCodigo().equals(ultimoItem.getCodigo())) {
					item.setQuantidade(Integer.parseInt(qnt));
					session.setAttribute("carrinho", carrinho);
				}
			}
		}
		
		return  "/WEB-INF/paginas/principal.jsp";
	}

	public String msgEmailConfimacao() {

		return "Segue pedido em anexo.\n\n" + "Para confirmar este pedido encaminnhar este e-mail junto com o anexo "
				+ "para o seu vendedor que nos lê em cópia (irpcanoas@hidrosistemas.com)\n\n\n"
				+ "Este é um e-mail gerado automaticamente, favor não respoder.";

	}

}
