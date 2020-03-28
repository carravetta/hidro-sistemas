package br.com.portal.hidrosistemas.web;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.portal.hidrosistemas.db.ConnectionPool;
import br.com.portal.hidrosistemas.db.HistoricoPedidosDAO;
import br.com.portal.hidrosistemas.model.Empresa;
import br.com.portal.hidrosistemas.model.HistoricoPedido;

public class Historico implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession();
		Empresa usuario = (Empresa) session.getAttribute("usuarioLogado");
		
		try (Connection con = new ConnectionPool().getConnetion()) {

			if (usuario != null) {
				session.setMaxInactiveInterval(60*10);
				List<HistoricoPedido> hist = new HistoricoPedidosDAO(con).listaHistoricoPedidos(usuario.getId());
				session.setAttribute("historicoPedido", hist);
				return "/WEB-INF/paginas/historico.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/index.jsp";
	}
}
