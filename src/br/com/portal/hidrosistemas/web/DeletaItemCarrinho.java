package br.com.portal.hidrosistemas.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.portal.hidrosistemas.model.Produto;

public class DeletaItemCarrinho implements Tarefa{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		HttpSession session = req.getSession();
		
		int excluirItem = Integer.parseInt(req.getParameter("item"));
		List<Produto> listaProdutoCarrinho = new ArrayList<>();
		listaProdutoCarrinho = (ArrayList<Produto>) session.getAttribute("carrinho");
		
		if(listaProdutoCarrinho != null) {
			listaProdutoCarrinho.remove(excluirItem-1);
			
		}
		session.setAttribute("carrinho", listaProdutoCarrinho);
		return "/WEB-INF/paginas/carrinhoCompras.jsp";
	}

}
