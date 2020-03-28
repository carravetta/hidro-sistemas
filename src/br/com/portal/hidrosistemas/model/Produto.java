package br.com.portal.hidrosistemas.model;

public class Produto {

	private String codigo;
	private String fantasia;
	private String descricao;
	private String unidade;
	private String link;
	private long id;
	private int grupo;
	private int quantidade = 1;
	
	public Produto(String codigo, String fantasia, String descricao, String unidade, String link, int grupo) {
		this.codigo = codigo;
		this.fantasia = fantasia;
		this.descricao = descricao;
		this.unidade = unidade;
		this.link = link;
		this.grupo = grupo;
	}


	public Produto(String descricao, String unidade, long id) {
		this.descricao = descricao;
		this.unidade = unidade;
		this.id = id;
	}
	
	public Produto(String descricao, String unidade, String codigo) {
		this.descricao = descricao;
		this.unidade = unidade;
		this.codigo = codigo;
	}


	public String getDescricao() {
		return descricao;
	}


	public int getGrupo() {
		return grupo;
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
	
	public String getFantasia() {
		return fantasia;
	}
	
	public String getLink() {
		return link;
	}

	@Override
	public String toString() {
		return "Produto [descricao=" + descricao + ", unidade=" + unidade + "]";
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public int getQuantidade() {
		return quantidade;
	}
	
	
	
	
	
}
