package br.com.portal.hidrosistemas.db;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;



public class ConnectionPool {

	private ComboPooledDataSource dataSource;

	public ConnectionPool() throws PropertyVetoException{
		
		ComboPooledDataSource pool = new ComboPooledDataSource();
		pool.setDriverClass("com.mysql.cj.jdbc.Driver");
		pool.setJdbcUrl("jdbc:mysql://localhost:3306/hidro_sistemas_portal?useTimezone=true&serverTimezone=America/Sao_Paulo");
		pool.setUser("root");
		pool.setPassword("C@rravetta1");
		pool.setMinPoolSize(1);
		pool.setAcquireIncrement(5);
		pool.setMaxPoolSize(20);
		this.dataSource = pool;
	}

	public Connection getConnetion() throws SQLException{
		Connection con = dataSource.getConnection();
		System.out.println(con.getCatalog());
		return con;
	}
	
}
