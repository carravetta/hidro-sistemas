package br.com.portal.hidrosistemas.web;

import java.sql.Connection;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.portal.hidrosistemas.db.ConnectionPool;
import br.com.portal.hidrosistemas.model.Empresa;

public class Perfil implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession();
		Empresa usuario = (Empresa) session.getAttribute("usuarioLogado");
		
		try(Connection con = new ConnectionPool().getConnetion()){
		
			if(usuario != null) {
				session.setMaxInactiveInterval(60*10);
				return "/WEB-INF/paginas/perfil.jsp";
			}
		
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
			return "index.jsp";

	}
}