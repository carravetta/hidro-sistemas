package br.com.portal.hidrosistemas.control;

import java.util.Calendar;

public class Pedido {

	private long id;
	private Calendar dataPedido;
	private long idEmpresa;
	
	public Pedido(long id, Calendar dataPedido, long idEmpresa) {
		this.id = id;
		this.dataPedido = dataPedido;
		this.idEmpresa = idEmpresa;
	}
	

	public Pedido(Calendar dataPedido, long idEmpresa) {
		this.dataPedido = dataPedido;
		this.idEmpresa = idEmpresa;
	}

	public long getId() {
		return id;
	}

	public Calendar getDataPedido() {
		return dataPedido;
	}

	public long getIdEmpresa() {
		return idEmpresa;
	}
	
	
	
}
