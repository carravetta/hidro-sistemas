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

import br.com.portal.hidrosistemas.control.Pedido;


public class PedidoDAO {
	
	private final Connection con;

	public PedidoDAO(Connection con) {
		this.con = con;
	}

	public long inserePedido(long empresa_idEmpresa) throws SQLException{
		con.setAutoCommit(false);
		String sql = "insert into pedido (data, empresa_idempresa) values(?, ?)";
		Date data = new Date();
		long idPedido = 0;
		try(PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			adiciona(data, empresa_idEmpresa, stmt);
			ResultSet res = stmt.getGeneratedKeys();
			while(res.next()) {
			idPedido = res.getLong(1);
			}
			con.commit();
			
		}catch(SQLException e) {
			e.printStackTrace();
			con.rollback();
		}
		
		return idPedido;
	}
	
	public void adiciona(Date data, long empresa_idEmpresa, PreparedStatement stmt) throws SQLException{
		
		Calendar c = Calendar.getInstance();
        data = c.getTime();
        DateFormat formataData = DateFormat.getDateInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		stmt.setString(1, sdf.format(data));
		stmt.setLong(2, empresa_idEmpresa);
		stmt.execute();
	}
	
}
