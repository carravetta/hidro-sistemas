package br.com.portal.hidrosistemas.model;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {

	private List<Produto> listaCompra;
	
	
	public CarrinhoCompras(Produto produto, double preco) {
		this.listaCompra.add(produto);
	}
	
	public CarrinhoCompras(ArrayList<Produto> produtos) {
		this.listaCompra = produtos;
	}

	public List<Produto> getListaCompra() {
		return listaCompra;
	}
	
}
