package br.com.portal.hidrosistemas.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class ItensDePedidoDAO {

	private final Connection con;

	public ItensDePedidoDAO(Connection con) {
	
		this.con = con;
	}
	
	public void insereItensNoPedido(String descricao, int quantidade, String unidade, long idPedido, String codigo) throws SQLException {
		
		con.setAutoCommit(false);
		String sql = "insert into itens_pedido (item, quantidade, unidade, pedido_idpedido, codigo) values(?, ?, ?, ?, ?)";
		
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, descricao);
			stmt.setInt(2, quantidade);
			stmt.setString(3, unidade);
			stmt.setLong(4, idPedido);
			stmt.setString(5, codigo);
			stmt.execute();
			con.commit();
		}catch(SQLException e) {
			e.printStackTrace();
			con.rollback();
		}
			
	}
	
}
