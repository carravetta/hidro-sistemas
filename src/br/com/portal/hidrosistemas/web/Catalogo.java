package br.com.portal.hidrosistemas.web;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.portal.hidrosistemas.db.ConnectionPool;
import br.com.portal.hidrosistemas.db.ProdutoDAO;
import br.com.portal.hidrosistemas.model.Empresa;
import br.com.portal.hidrosistemas.model.Produto;

public class Catalogo implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		HttpSession session = req.getSession();
		Connection con = new ConnectionPool().getConnetion();
		session.setAttribute("pesquisaProduto", null);
		session.setAttribute("pesquisa", null);
		session.setAttribute("usuarioPadrao", "usuarioPadrao");
		
		double totalProdutos = new ProdutoDAO(con).totalProdutos();
		totalProdutos = Math.ceil(totalProdutos / 30);
		session.setAttribute("totalProduto", totalProdutos);
					
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
	
		
		return  "/catalogo.jsp";
	}


	}


