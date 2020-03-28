package br.com.portal.hidrosistemas.web;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.portal.hidrosistemas.db.ConnectionPool;
import br.com.portal.hidrosistemas.model.Empresa;

public class Verificacao implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		Empresa usuario = (Empresa) session.getAttribute("usuarioLogado");
		
		if(usuario!=null)	{
				session.setAttribute("pedidoEnviado", null);
				return "/WEB-INF/paginas/verificacao.jsp";
		}
		
		else
			return "index.jsp";

	
	}
}
