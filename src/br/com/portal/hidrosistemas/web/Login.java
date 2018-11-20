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

		HttpSession session = req.getSession();
		Empresa empresa = (Empresa) session.getAttribute("usuarioLogado");
		
		if(empresa != null)
			return "/WEB-INF/paginas/pedidos.jsp";
		
		try (Connection con = new ConnectionPool().getConnetion()) {
			String email = req.getParameter("e-mail");
			String senha = req.getParameter("senha");
			
			empresa = new EmpresaDAO(con).buscaLogin(email, senha);
			
			if (empresa != null) {
				session = req.getSession();
				session.setAttribute("usuarioLogado", empresa);
				session.setMaxInactiveInterval(10*60);
				return "/WEB-INF/paginas/pedidos.jsp";

			}
		}
		req.setAttribute("erroLogin", "Usuario ou senha invalidos");
		return "/index.jsp";
	}
}