package br.com.portal.hidrosistemas.model;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.portal.hidrosistemas.db.ConnectionPool;
import br.com.portal.hidrosistemas.web.JsonWrite;

public class TesyaJSON {

	public static void main(String[] args) throws SQLException, Exception {
		Connection con = new ConnectionPool().getConnetion();
		JsonWrite json = new JsonWrite(con);
		json.jsonWriter();
	}

}
