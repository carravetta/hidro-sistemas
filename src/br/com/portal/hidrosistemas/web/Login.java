package br.com.portal.hidrosistemas.web;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.portal.hidrosistemas.control.Empresa;
import br.com.portal.hidrosistemas.db.ConnectionPool;
import br.com.portal.hidrosistemas.db.EmpresaDAO;
public class Login implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		String email = req.getParameter("e-mail");
		String senha = req.getParameter("senha");

		try (Connection con = new ConnectionPool().getConnetion()) {
			
			Empresa empresa = new EmpresaDAO(con).buscaLogin(email, senha);
			
			if (empresa != null) {
				HttpSession session = req.getSession();
				session.setAttribute("usuarioLogado", empresa);
				session.setMaxInactiveInterval(10*60);
				System.out.println(empresa.isAdmin());
				return "/WEB-INF/paginas/pedidos.jsp";

			}
		}
		req.setAttribute("erroLogin", "Usuario ou senha invalidos");
		return "/index.jsp";
	}
}