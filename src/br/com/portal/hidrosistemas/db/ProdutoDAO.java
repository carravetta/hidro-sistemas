package br.com.portal.hidrosistemas.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import br.com.portal.hidrosistemas.model.Produto;

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
					String fantasia = res.getString("fantasia");
					String unidade = res.getString("unidade");
					String link = res.getString("link");
					int grupo = res.getInt("grupo_id");
					
					Produto produto = new Produto(codigo, fantasia, descricao, unidade, link, grupo);
					listaProdutos.add(produto);
				}
			}
			return listaProdutos;
		}
	}
	
	public List<Produto> listaProdutos(int offset) throws SQLException{
		List<Produto> listaProdutos = new ArrayList<>();
		String sql = "select * from produto limit 30 offset " + offset;
		try(Statement stmt = con.createStatement()){
			stmt.execute(sql);
			try(ResultSet res = stmt.getResultSet()){
				while(res.next()) {
					String codigo = res.getString("codigo");
					String descricao = res.getString("descricao");
					String fantasia = res.getString("fantasia");
					String unidade = res.getString("unidade");
					String link = res.getString("link");
					int grupo = res.getInt("grupo_id");
					
					Produto produto = new Produto(codigo, fantasia, descricao, unidade, link, grupo);
					listaProdutos.add(produto);
					
				}
			}
			return listaProdutos;
		}
	}
	
	public int totalProdutos() throws SQLException{
		String sql = "select count(*) AS cont from produto";
		int total = 0;
		try (Statement stmt = con.createStatement()){
			stmt.execute(sql);
			try(ResultSet res = stmt.getResultSet()){
				res.next();
				total = Integer.parseInt(res.getString("cont"));
			}
		}
		
		return total;
	}
	
	public int totalProdutosPorPesquisa(List<String> listaDePesquisa) throws SQLException{
		
		if(listaDePesquisa.size()==0)
			return 0;
		String sql = "select count(*) AS cont from produto where descricao like ";
		int total = 0;
		
		for(String item : listaDePesquisa) {
			sql += "'%"+item+"%' ";
		}
		System.out.println("SQL total produtos: "+sql);
		try (Statement stmt = con.createStatement()){
			stmt.execute(sql);
			try(ResultSet res = stmt.getResultSet()){
				res.next();
				total = Integer.parseInt(res.getString("cont"));
			}
		}
		
		return total;
	}
	
	public List<Produto> buscaPorGrupo(int id, Produto produto){
			
			List<Produto> listaGrupo = new ArrayList<>();
			String sql = "select * from produto where grupo_id = "+ id;
			
			try (Statement stmt = con.createStatement()) {
			   stmt.execute(sql);
				ResultSet res = stmt.getResultSet();
				while(res.next()) {
					String codigo = res.getString("codigo");
					String descricao = res.getString("descricao");
					String fantasia = res.getString("fantasia");
					String unidade = res.getString("unidade");
					String link = res.getString("link");
					int grupo = res.getInt("grupo_id");
					
					Produto produto2 = new Produto(codigo, fantasia, descricao, unidade, link, grupo);
					
					if(produto.getCodigo().equals(produto2.getCodigo()) == false)		
					listaGrupo.add(produto2);
				}

				
			}catch(SQLException sqle) {
				sqle.printStackTrace();
			}
			
			return listaGrupo;
		}
	
	public List<Produto> pesquisaProduto(List<String> listaDePesquisa, int offset){
		
		List<Produto> resultado = new ArrayList<>();
		
		String sql = "select * from produto where descricao like ";
		
		for(String item : listaDePesquisa) {
			System.out.println(item);
			sql += "'%"+item+"%' ";
		}
		
		sql+= " limit 30 offset "+offset;
		System.out.println("SQL pesquisa produtos: "+sql);
		
		try (Statement stmt = con.createStatement()) {
		   stmt.execute(sql);
			ResultSet res = stmt.getResultSet();
			while(res.next()) {
				String codigo = res.getString("codigo");
				String descricao = res.getString("descricao");
				String fantasia = res.getString("fantasia");
				String unidade = res.getString("unidade");
				String link = res.getString("link");
				int grupo = res.getInt("grupo_id");
				
				Produto produto = new Produto(codigo, fantasia, descricao, unidade, link, grupo);
		
				resultado.add(produto);
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();;
		}
		return resultado;		
	}
	
}
