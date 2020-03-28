package br.com.portal.hidrosistemas.web;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.util.SystemOutLogger;

import br.com.portal.hidrosistemas.db.ConnectionPool;
import br.com.portal.hidrosistemas.db.ProdutoDAO;
import br.com.portal.hidrosistemas.model.Produto;

public class PesquisaProduto implements Tarefa {

	private List<String> listaDePesquisa;
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();

		String pesquisa = req.getParameter("pesquisa");
		String pagina = req.getParameter("pagina");
		String excluirPesquisa = req.getParameter("excluirPesquisa");
		String usuarioPadrao = (String) session.getAttribute("usuarioPadrao");
		Connection con = new ConnectionPool().getConnetion();
		this.listaDePesquisa = (List<String>) session.getAttribute("listaDePesquisa");
		double totalProdutos = 0.0;
		
		if(excluirPesquisa != null) {
			if(this.listaDePesquisa.size() == 0) {
				if(usuarioPadrao.equals("usuarioPadrao"))
					return new Catalogo().executa(req, resp);
				
				return new Principal().executa(req, resp);
			}
			
			this.listaDePesquisa.remove(Integer.parseInt(excluirPesquisa));
			
			if(usuarioPadrao.equals("usuarioPadrao"))
				return new Catalogo().executa(req, resp);
			
			return new Principal().executa(req, resp);
		}
		
		if(this.listaDePesquisa == null) {
			this.listaDePesquisa = new ArrayList<>();
		}

		if (pesquisa != null) {
			listaDePesquisa.add(pesquisa);
			session.setAttribute("listaDePesquisa", listaDePesquisa);
			totalProdutos = new ProdutoDAO(con).totalProdutosPorPesquisa(listaDePesquisa);
		} else {
			listaDePesquisa = (List<String>) session.getAttribute("listaDePesquisa");
			totalProdutos = new ProdutoDAO(con).totalProdutosPorPesquisa(listaDePesquisa);
		}

		totalProdutos = Math.ceil(totalProdutos / 30);
		session.setAttribute("totalProduto", totalProdutos);

		if (pagina == null) {
			pagina = "1";
			pesquisaProdutoPorPagina(req, session, listaDePesquisa, pagina, con);
		} else {
			pesquisa = (String) session.getAttribute("pesquisa");
			pesquisaProdutoPorPagina(req, session, listaDePesquisa, pagina, con);
		}
		
		if(usuarioPadrao.equals("usuarioPadrao"))
			return "/catalogo.jsp";
		
		return "/WEB-INF/paginas/principal.jsp";
	}

	private void pesquisaProdutoPorPagina(HttpServletRequest req, HttpSession session, List<String> listaDePesquisa, String pagina,
			Connection con) {
		List<Produto> resultado;
		resultado = new ProdutoDAO(con).pesquisaProduto(listaDePesquisa, (Integer.parseInt(pagina) * 30) - 30);
		req.setAttribute("pesquisaProduto", resultado);
	}
}
