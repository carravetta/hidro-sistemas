package br.com.portal.hidrosistemas.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.portal.hidrosistemas.model.ItensPedido;
import br.com.portal.hidrosistemas.model.Pedido;
import br.com.portal.hidrosistemas.model.Produto;
import br.com.portal.hidrosistemas.util.JPAUtil;



public class ItensDePedidoDAO {

	private final Connection con;

	public ItensDePedidoDAO(Connection con) {
	
		this.con = con;
	}
	
	public void insereItensNoPedido(Produto produto, int quantidade, long idPedido) throws SQLException {
				
			ItensPedido novoItem = new ItensPedido(produto, quantidade, idPedido);
		
			EntityManager em = new JPAUtil().getEntityManager();
			
			em.getTransaction().begin();
			
			em.persist(novoItem);
			
			em.getTransaction().commit();
			em.close();			
	}
	
	public List<ItensPedido> buscaPedido(long idPedido) throws SQLException {
		String sql = "select pedido.data, idpedido, itenspedido.codigo, item, quantidade, unidade "+ 
				"from itenspedido inner join pedido on pedido.idpedido = itenspedido.pedido_idpedido where idpedido = "+idPedido;
		List<ItensPedido> itensDoPedido = new ArrayList<>();
		try (Statement stmt = con.prepareStatement(sql)) {
			//stmt.setInt(1, (int) idPedido);
			stmt.execute(sql);
			try (ResultSet res = stmt.getResultSet()) {
				while (res.next()) {
					Date data = res.getDate(1);
					String codigo = res.getString(3);
					String item = res.getString(4);
					int quantidade = res.getInt(5);
					String unidade = res.getString(6);
					
					Produto produto = new Produto(item, unidade, codigo);
					
					itensDoPedido.add(new ItensPedido(produto, quantidade, idPedido, data));
					
				}
			}	
		}
		return itensDoPedido;
	}
}
