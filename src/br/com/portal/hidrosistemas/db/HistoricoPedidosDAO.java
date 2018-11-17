package br.com.portal.hidrosistemas.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.com.portal.hidrosistemas.control.HistoricoPedido;
public class HistoricoPedidosDAO {

	private Connection con;

	public HistoricoPedidosDAO(Connection con) {
		this.con = con;
	}

	public List<HistoricoPedido> listaHistoricoPedidos(long idEmpresa) throws SQLException {
		List<HistoricoPedido> listaPedidos = new ArrayList<>();
		String sql = "select data, idpedido,  empresa_idempresa, itens_pedido.codigo, item, quantidade, unidade "
				+ "from pedido inner join itens_pedido on pedido.idpedido = itens_pedido.pedido_idpedido";

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
					
					if(idEmpresa == idEmp) {
						listaPedidos.add(new HistoricoPedido(idEmp, idPedido, data, codigo, item, quantidade, unidade));
					}
				}
			}
		}

		return listaPedidos;
	}

}
