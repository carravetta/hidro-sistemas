package br.com.portal.hidrosistemas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idempresa;
	private String razaoSocial;
	private String fantasia;
	private String cnpj_cpf;
	private String insc_estadual;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String telefone;
	private int numero;
	private String email;
	private String senha;
	private boolean isadmin;	
	
	@Deprecated
	public Empresa() {
	}

	public Empresa(long id, String razaoSocial, String fantasia, String cnpj_cpf, String inscEstadual, String rua,
			String bairro, String cidade, String estado, String cep, String telefone, String email, String senha,
			boolean admin, int numero) {
		this.idempresa = id;
		this.razaoSocial = razaoSocial;
		this.fantasia = fantasia;
		this.cnpj_cpf = cnpj_cpf;
		this.insc_estadual = inscEstadual;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.isadmin = admin;
		this.numero = numero;
	}
	
	public Empresa( String razaoSocial, String fantasia, String cnpj_cpf, String inscEstadual, String rua,
			String bairro, String cidade, String estado, String cep, String telefone, String email,
			String senha, int numero) {
		
		this.razaoSocial = razaoSocial;
		this.fantasia = fantasia;
		this.cnpj_cpf = cnpj_cpf;
		this.insc_estadual = inscEstadual;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.numero = numero;
	}


	public long getId() {
		return idempresa;
	}


	public String getRazaoSocial() {
		return razaoSocial;
	}


	public String getFantasia() {
		return fantasia;
	}


	public String getCnpj_cpf() {
		return cnpj_cpf;
	}


	public String getInscEstadual() {
		return insc_estadual;
	}


	public String getRua() {
		return rua;
	}


	public String getBairro() {
		return bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public String getEstado() {
		return estado;
	}


	public String getCep() {
		return cep;
	}


	public String getTelefone() {
		return telefone;
	}


	public int getNumero() {
		return numero;
	}


	public String getEmail() {
		return email;
	}


	public String getSenha() {
		return senha;
	}


	public boolean isAdmin() {
		return isadmin;
	}



	@Override
	public String toString() {
		return "Raz�o Social: " + razaoSocial + "\n" +
			   "CNPJ: " + cnpj_cpf + "\n" +
			   "Insc. Estadual " + insc_estadual +"\n"+ 
			   "Rua: " + rua + ", "+numero + "\n" + 
			   "Bairro: " + bairro + "\n" +
			   "Cidade: " + cidade + "\n" +
			   "Estado: " + estado + "\n" +
			   "CEP: " + cep + "\n" +
			   "Telefone: " + telefone + "\n" +
			   "Email: " + email + "\n\n"+
			   "Codigo           "+"  Descri��o \n"; 
	} 


	
	

	
	
	
}
