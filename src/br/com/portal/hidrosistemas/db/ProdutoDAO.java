package br.com.portal.hidrosistemas.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.portal.hidrosistemas.control.Produto;

public class ProdutoDAO {
	
	private final Connection con;

	public ProdutoDAO(Connection con) {
		this.con = con;
	}
	
	public List<Produto> listaProdutos() throws SQLException{
		List<Produto> listaProdutos = new ArrayList<>();
		String sql = "select * from produto";
		try(Statement stmt = con.createStatement()){
			stmt.execute(sql);
			try(ResultSet res = stmt.getResultSet()){
				while(res.next()) {
					String codigo = res.getString("codigo");
					String descricao = res.getString("descricao");
					String unidade = res.getString("unidade");
					
					Produto produto = new Produto(codigo, descricao, unidade);
					listaProdutos.add(produto);
				}
			}
			return listaProdutos;
		}
	}
}
