package br.com.portal.hidrosistemas.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.portal.hidrosistemas.control.HistoricoPedido;

public class TestaHistorico {

	public static void main(String[] args) throws SQLException, Exception {

		try (Connection con = new ConnectionPool().getConnetion()) {
			List<HistoricoPedido> hist = new HistoricoPedidosDAO(con).listaHistoricoPedidos(1);
			
			for(HistoricoPedido ped : hist) {
				System.out.println(ped.toString());	
			}
		}

	}

}
