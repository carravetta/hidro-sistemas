package br.com.portal.hidrosistemas.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		String tarefa = req.getParameter("tarefa");
		
		if(tarefa == null)
			return null;
		else {
			HttpSession session = req.getSession();
			session.invalidate();
		}
		
		return "/index.jsp";
		
	}
}
