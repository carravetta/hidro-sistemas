package br.com.portal.hidrosistemas.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPedido;
	
	@Temporal(TemporalType.DATE)
	private Date data;

	private long empresa_idEmpresa;
	
	public Pedido(long id, Date dataPedido, long idEmpresa) {
		this.idPedido = id;
		this.data = dataPedido;
		this.empresa_idEmpresa = idEmpresa;
	}
	

	public Pedido(Date dataPedido, long idEmpresa) {
		this.data = dataPedido;
		this.empresa_idEmpresa = idEmpresa;
	}

	public long getId() {
		return idPedido;
	}

	public Date getDataPedido() {
		return data;
	}

	public long getIdEmpresa() {
		return empresa_idEmpresa;
	}
	
	
	
}
