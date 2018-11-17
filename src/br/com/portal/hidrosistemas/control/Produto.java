package br.com.portal.hidrosistemas.control;

public class Produto {

	private String codigo;
	private String descricao;
	private String unidade;
	private long id;
	
	
	public Produto(String codigo, String descricao, String unidade) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.unidade = unidade;
	}


	public Produto(String descricao, String unidade, long id) {
		this.descricao = descricao;
		this.unidade = unidade;
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public String getUnidade() {
		return unidade;
	}


	public long getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Produto [descricao=" + descricao + ", unidade=" + unidade + "]";
	}
	
	
	
	
	
}
