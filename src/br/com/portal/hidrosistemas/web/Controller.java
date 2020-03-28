package br.com.portal.hidrosistemas.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.portal.hidrosistemas.model.Empresa;


@WebServlet(urlPatterns = "/exec")
public class Controller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String tarefa = req.getParameter("tarefa");
		if (tarefa == null) {
			throw new IllegalArgumentException("Voce esqueceu de passar a tarefa");
		}
		
			try {
				RequestDispatcher dispatcher;
				
				String nomeClasse = "br.com.portal.hidrosistemas.web." + tarefa;
				Class<?> type = Class.forName(nomeClasse);
				Tarefa instancia = (Tarefa) type.newInstance();
				String pagina = instancia.executa(req, resp);
				dispatcher = req.getRequestDispatcher(pagina);
				dispatcher.forward(req, resp);		
		
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
}

