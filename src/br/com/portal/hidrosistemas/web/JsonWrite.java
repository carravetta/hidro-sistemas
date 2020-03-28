package br.com.portal.hidrosistemas.web;

import java.io.FileWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;

import br.com.portal.hidrosistemas.db.ProdutoDAO;
import br.com.portal.hidrosistemas.model.Produto;

public class JsonWrite {

	JSONObject jsonObject;
	Connection con;

	public JsonWrite(Connection con) {
		this.jsonObject = new JSONObject();
		this.con = con;
	}
	
	public void jsonWriter() throws Exception {
		FileWriter writerFile = null;
		ProdutoDAO produtoDAO = new ProdutoDAO(con);
		List<Produto> listaProdutos = new ArrayList<>();
		listaProdutos.addAll(produtoDAO.listaProdutos());
		
		ArrayList<JSONObject> json = new ArrayList<>();
		
		for (Produto produtos : listaProdutos) {
			JSONObject jobj = new JSONObject();
			jobj.put("unidade", produtos.getUnidade());
			json.add(jobj);
			jobj.put("descricao", produtos.getDescricao());
			jobj.put("fantasia", produtos.getFantasia());
			jobj.put("link", produtos.getLink());

		}
	
		writerFile = new FileWriter("../hidro-sistemas/WebContent/JSONProdutos.json");
		writerFile.write("[");

		for(JSONObject lista : json) {
			writerFile.write(lista.toJSONString()+",");
		}
		writerFile.write("]");
		writerFile.close();
	}
	
	public List<Produto> listaProdutos() throws Exception {
		ProdutoDAO produtoDAO = new ProdutoDAO(con);
		List<Produto> listaProdutos = new ArrayList<>();
		listaProdutos.addAll(produtoDAO.listaProdutos());
	
		return listaProdutos;
	
	}
}

