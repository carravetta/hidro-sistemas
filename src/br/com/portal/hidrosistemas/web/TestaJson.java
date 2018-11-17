package br.com.portal.hidrosistemas.web;

import java.sql.Connection;

import br.com.portal.hidrosistemas.db.ConnectionPool;

public class TestaJson {

	public static void main(String[] args) throws Exception {
	
	Connection con = new ConnectionPool().getConnetion() ;
	JsonWrite json = new JsonWrite(con);
	json.jsonWriter();
		
	}
}
