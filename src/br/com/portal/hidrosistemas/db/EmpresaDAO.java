package br.com.portal.hidrosistemas.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.portal.hidrosistemas.control.Empresa;

public class EmpresaDAO {

	private final Connection con;

	public EmpresaDAO(Connection con) {
		this.con = con;
	}
	
	public Empresa buscaLogin(String email, String senha) throws SQLException{
		
		List<Empresa> empresaList = new ArrayList<>();
		
		String sql = "select * from empresa";
		
		try(Statement stmt = con.createStatement()){
			stmt.execute(sql);
			
			try(ResultSet res = stmt.getResultSet()){
				
				while(res.next()) {
					 long id = res.getLong("idempresa");
					 String userEmail = res.getString("email");
					 String userSenha = res.getString("senha");
					 String razaoSocial = res.getString("razaoSocial");
					 String fantasia = res.getString("fantasia");
					 String cnpj_cpf = res.getString("cnpj_cpf");
					 String inscEstadual = res.getString("insc_Estadual");
					 String rua = res.getString("rua");
					 String bairro = res.getString("bairro");
					 String cidade = res.getString("cidade");
					 String estado = res.getString("estado");
					 String cep = res.getString("cep");
					 int numero = res.getInt("numero");
					 String telefone = res.getString("telefone");
					 boolean isadmin = res.getBoolean("isadmin");
					 
					 Empresa empresa = new Empresa(id, razaoSocial, fantasia, cnpj_cpf, inscEstadual, rua,
							 bairro, cidade, estado, cep, telefone, userEmail, userSenha, isadmin, numero);
					 
					 empresaList.add(empresa);
				}
				for(Empresa emp : empresaList) {
					if(email.equals(emp.getEmail()) && senha.equals(emp.getSenha())) {
						return emp;
					}
				}
			}			
		}		
		return null;
	}
	
}
