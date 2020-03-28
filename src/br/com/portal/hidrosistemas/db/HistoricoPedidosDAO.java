package br.com.portal.hidrosistemas.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.portal.hidrosistemas.model.HistoricoPedido;
import br.com.portal.hidrosistemas.model.Pedido;
import br.com.portal.hidrosistemas.model.Produto;
public class HistoricoPedidosDAO {

	private Connection con;

	public HistoricoPedidosDAO(Connection con) {
		this.con = con;
	}

	public List<HistoricoPedido> listaHistoricoPedidos(long idEmpresa) throws SQLException {
		List<HistoricoPedido> listaPedidos = new ArrayList<>();
		String sql = "select pedido.data, idpedido,  empresa_idempresa, itenspedido.codigo, item, quantidade, unidade "
				+ "from pedido inner join itenspedido on pedido.idpedido = itenspedido.pedido_idpedido";

		try (Statement stmt = con.createStatement()) {
			stmt.execute(sql);
			try (ResultSet res = stmt.getResultSet()) {
				while (res.next()) {
					Date data = res.getDate(1);
					long idPedido = res.getLong(2);
					long idEmp = res.getLong(3);
					String codigo = res.getString(4);
					String item = res.getString(5);
					int quantidade = res.getInt(6);
					String unidade = res.getString(7);
					
					Produto produto = new Produto(item, unidade, codigo);
					
					if(idEmpresa == idEmp) {
						listaPedidos.add(new HistoricoPedido(idEmpresa, idPedido, data, produto, quantidade));
					}
				}
			}
		}

		return listaPedidos;
	}
	
	
}
