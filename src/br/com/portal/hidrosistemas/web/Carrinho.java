package br.com.portal.hidrosistemas.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Carrinho implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		HttpSession session = req.getSession();
		
		return "/WEB-INF/paginas/carrinhoCompras.jsp";
	}
	
	

}
