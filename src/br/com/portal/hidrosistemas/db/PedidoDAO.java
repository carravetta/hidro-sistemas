package br.com.portal.hidrosistemas.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Date;

import javax.persistence.EntityManager;

import br.com.portal.hidrosistemas.model.HistoricoPedido;
import br.com.portal.hidrosistemas.model.Pedido;
import br.com.portal.hidrosistemas.model.Produto;
import br.com.portal.hidrosistemas.util.JPAUtil;

public class PedidoDAO {

	private final Connection con;

	public PedidoDAO(Connection con) {
		this.con = con;
	}

	public Pedido inserePedido(long empresa_idEmpresa) throws SQLException {
		
		Date data = new Date();
		Calendar c = Calendar.getInstance();
		data = c.getTime();
		DateFormat formataData = DateFormat.getDateInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Pedido pedido = new Pedido(data, empresa_idEmpresa);
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();;
		
		em.persist(pedido);
		em.getTransaction().commit();
		em.close();
		
		return pedido;
	
	}


}
