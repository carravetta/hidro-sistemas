package br.com.portal.hidrosistemas.control;

import java.util.Date;

public class HistoricoPedido {

	private long idEmpresa;
	private long idPedido;
	private Date data;
	private String codigo;
	private String descricao;
	private int quantidade;
	private String unidade;
	
	
	public HistoricoPedido(long idEmpresa, long idPedido, Date data, String codigo, String descricao, int quantidade,
			String unidade) {

		this.idEmpresa = idEmpresa;
		this.idPedido = idPedido;
		this.data = data;
		this.codigo = codigo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.unidade = unidade;
	}


	public long getIdEmpresa() {
		return idEmpresa;
	}


	public long getIdPedido() {
		return idPedido;
	}


	public Date getData() {
		return data;
	}


	public String getCodigo() {
		return codigo;
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


	@Override
	public String toString() {
		return "HistoricoPedido [idEmpresa=" + idEmpresa + ", idPedido=" + idPedido + ", data=" + data + ", codigo="
				+ codigo + ", descricao=" + descricao + ", quanitdade=" + quantidade + ", unidade=" + unidade + "]";
	}
	
	
	
}
