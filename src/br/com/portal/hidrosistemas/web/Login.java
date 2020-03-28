package br.com.portal.hidrosistemas.web;

import java.sql.Connection;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.portal.hidrosistemas.db.ConnectionPool;
import br.com.portal.hidrosistemas.db.EmpresaDAO;
import br.com.portal.hidrosistemas.db.ProdutoDAO;
import br.com.portal.hidrosistemas.model.Empresa;
import br.com.portal.hidrosistemas.model.Produto;
@WebServlet(urlPatterns = "/login")
public class Login implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();
		Empresa empresa = (Empresa) session.getAttribute("usuarioLogado");
		session.setAttribute("pesquisaProduto", null);
		session.setAttribute("usuarioPadrao", "usuarioLogado");
		if(empresa != null)
			return "/WEB-INF/paginas/principal.jsp";
		
		
		try (Connection con = new ConnectionPool().getConnetion()) {
			String email = req.getParameter("e-mail");
			String senha = req.getParameter("senha");
			
			empresa = new EmpresaDAO(con).buscaLogin(email, senha);
			
			
			if (empresa != null) {
				session = req.getSession();
				session.setAttribute("usuarioLogado", empresa);
				session.setMaxInactiveInterval(10*60);
				List<Produto> listaProdutos = new ProdutoDAO(con).listaProdutos(0);
				session.setAttribute("listaProdutos", listaProdutos);
				double totalProdutos = new ProdutoDAO(con).totalProdutos();
				totalProdutos = Math.ceil(totalProdutos/30);
				session.setAttribute("totalProduto", totalProdutos);
				session.setAttribute("ultimaPagina", 1);
				return "/WEB-INF/paginas/principal.jsp";

			}
		}catch(NullPointerException e) {
			return "/index.jsp";
		}
		req.setAttribute("erroLogin", "Usuario ou senha invalidos");
		return "/index.jsp";
	}
}