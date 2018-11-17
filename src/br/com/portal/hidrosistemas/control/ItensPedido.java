package br.com.portal.hidrosistemas.control;

public class ItensPedido {

	private long idItensPedido;
	private String descricao;
	private int quantidade;
	private String unidade;
	private long pedido_idPedido;
	
	
	public ItensPedido(long idItensPedido, String descricao, int quantidade, String unidade, long pedido_idPedido) {
		this.idItensPedido = idItensPedido;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.unidade = unidade;
		this.pedido_idPedido = pedido_idPedido;
	}


	public long getIdItensPedido() {
		return idItensPedido;
	}


	public String getDescricao() {
		return descricao;
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
	
	
	
	
}
