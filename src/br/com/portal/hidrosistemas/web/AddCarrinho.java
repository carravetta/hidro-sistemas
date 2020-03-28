package br.com.portal.hidrosistemas.web;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.portal.hidrosistemas.db.ConnectionPool;
import br.com.portal.hidrosistemas.db.ProdutoDAO;
import br.com.portal.hidrosistemas.model.CarrinhoCompras;
import br.com.portal.hidrosistemas.model.Produto;

public class AddCarrinho implements Tarefa{
	
	private ArrayList<Produto> listaProdutoCarrinho;
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		Connection con = new ConnectionPool().getConnetion();
		
		
		HttpSession session = req.getSession();
		
		String descricao = req.getParameter("descricao");
		String codigo = req.getParameter("codigo");
		String fantasia = req.getParameter("fantasia");
		String unidade = req.getParameter("unidade");
		String link = req.getParameter("link");
		String grupo = req.getParameter("grupo");
		
		Produto produto = new Produto(codigo, fantasia, descricao, unidade, link, Integer.parseInt(grupo));
		if(session.getAttribute("carrinho")==null)
			listaProdutoCarrinho = new ArrayList<>();
		else {
			listaProdutoCarrinho = (ArrayList<Produto>) session.getAttribute("carrinho");
		}
		
		listaProdutoCarrinho.add(produto);
		CarrinhoCompras carrinho = new CarrinhoCompras(listaProdutoCarrinho);
		List<Produto> listaGrupo = new ProdutoDAO(con).buscaPorGrupo(produto.getGrupo(), produto);
		
		session.setAttribute("listaGrupo", listaGrupo);
		session.setAttribute("carrinho", carrinho.getListaCompra());
		session.setAttribute("ultimoItem", produto);
		
		
		return "/WEB-INF/paginas/produtoAdicionado.jsp";
	}
	
	
}

	
