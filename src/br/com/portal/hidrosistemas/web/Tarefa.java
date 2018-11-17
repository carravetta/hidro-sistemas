package br.com.portal.hidrosistemas.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Tarefa {

	String executa (HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
