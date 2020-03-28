package br.com.portal.hidrosistemas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItensPedido {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idItens_Pedido;
	private String item;
	private int quantidade;
	private String unidade;
	private long pedido_idPedido;
	private String codigo;
	private Date data;
	
	
	public Date getData() {
		return data;
	}



	public ItensPedido(long idItensPedido, Produto produto, int quantidade, long pedido_idPedido) {
		
		this.idItens_Pedido = idItensPedido;
		this.item = produto.getDescricao();
		this.quantidade = quantidade;
		this.unidade = produto.getUnidade();
		this.pedido_idPedido = pedido_idPedido;
	}

	

	public ItensPedido(Produto produto, int quantidade, long pedido_idPedido) {

		this.item = produto.getDescricao();
		this.quantidade = quantidade;
		this.unidade = produto.getUnidade();
		this.pedido_idPedido = pedido_idPedido;
		this.codigo = produto.getCodigo();
	}
	
	public ItensPedido(Produto produto, int quantidade, long pedido_idPedido, Date data) {

		this.item = produto.getDescricao();
		this.quantidade = quantidade;
		this.unidade = produto.getUnidade();
		this.pedido_idPedido = pedido_idPedido;
		this.codigo = produto.getCodigo();
		this.data = data;
	}



	public long getIdItensPedido() {
		return idItens_Pedido;
	}


	public String getDescricao() {
		return item;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public String getUnidade() {
		return unidade;
	}


	public long getPedido_idPedido() {
		return pedido_idPedido;
	}


	public String getCodigo() {
		return codigo;
	}
	
	
	
	
}
