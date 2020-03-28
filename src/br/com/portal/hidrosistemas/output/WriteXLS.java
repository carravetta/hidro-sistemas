package br.com.portal.hidrosistemas.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import br.com.portal.hidrosistemas.model.Empresa;
import br.com.portal.hidrosistemas.model.ItensPedido;
import br.com.portal.hidrosistemas.model.Pedido;
import br.com.portal.hidrosistemas.web.Principal;

public class WriteXLS {
	
	HSSFWorkbook workbook;

	public WriteXLS () {
		this.workbook = new HSSFWorkbook();
	}
	
	public void escrevePedidoXLS(Empresa cliente, List<ItensPedido> pedido, long idPedido ) {
		HSSFSheet sheetPedido = workbook.createSheet("PEDIDO" + idPedido);
		
		int rownum = 0;
		Row row = sheetPedido.createRow(rownum++);
		int cellnum = 0;
		
		Cell razaoSocial = row.createCell(cellnum++);
		razaoSocial.setCellValue("Razão Social: "+ cliente.getRazaoSocial());
		
		Cell cnpj = row.createCell(cellnum++);
		cnpj.setCellValue("CNPJ/CPF: "  + cliente.getCnpj_cpf());
		
		Cell inscEst = row.createCell(cellnum++);
		inscEst.setCellValue("Isc. Estadual: "+cliente.getInscEstadual());
		
		//rownum++; //pula linha dados cliente
		row = sheetPedido.createRow(rownum);
		cellnum = 0;
		
		Cell rua = row.createCell(cellnum++);
		rua.setCellValue("Rua: " + cliente.getRua() + ", "+ cliente.getNumero());
		
		Cell bairro = row.createCell(cellnum++);
		bairro.setCellValue("Bairro: " + cliente.getBairro());
		
		Cell cidade = row.createCell(cellnum++);
		cidade.setCellValue("Cidade: " + cliente.getCidade() + ", " + cliente.getEstado());
		
		rownum++; //pula linha dados cliente
		row = sheetPedido.createRow(rownum);
		cellnum = 0;
		
		Cell cep = row.createCell(cellnum++);
		cep.setCellValue("CEP: " + cliente.getCep());
		
		Cell telefone = row.createCell(cellnum++);
		telefone.setCellValue("Telefone: " + cliente.getTelefone());
		
		Cell email = row.createCell(cellnum++);
		email.setCellValue("E-mail: " + cliente.getEmail());
		
		rownum++;
		rownum++; //pula linha dados cliente
		row = sheetPedido.createRow(rownum);
		cellnum = 0;
		
		Cell numPedido = row.createCell(cellnum++);
		numPedido.setCellValue("PEDIDO: " + idPedido);
		
		Cell data = row.createCell(cellnum++);
		data.setCellValue("DATA: " + getDataAtual());
		
		rownum++;
		rownum++; //pula linha dados pedido
		row = sheetPedido.createRow(rownum);
		cellnum = 0;
		
		Cell codItem = row.createCell(cellnum++);
		codItem.setCellValue("CODIGO");
		
		Cell item = row.createCell(cellnum++);
		item.setCellValue("DESCRIÇÃO");
		
		Cell quant = row.createCell(cellnum++);
		quant.setCellValue("QUANTIDADE");
		
		Cell unidade = row.createCell(cellnum++);
		unidade.setCellValue("UNIDADE");
		
		rownum++; //pula linha dados pedido
		row = sheetPedido.createRow(rownum);
		
		
		for(ItensPedido items : pedido) {
			cellnum = 0;
			
			Cell codigo = row.createCell(cellnum++);
			codigo.setCellValue(items.getCodigo());
			
			Cell descricao = row.createCell(cellnum++);
			descricao.setCellValue(items.getDescricao());
			
			Cell quantidade = row.createCell(cellnum++);
			quantidade.setCellValue(items.getQuantidade());
			
			Cell unid = row.createCell(cellnum++);
			 unid.setCellValue(items.getUnidade());
			
			
		}
		
		
		try {
			
			FileOutputStream arquivoPedido = new FileOutputStream(new File("PEDIDO "+idPedido+".xls"));
			workbook.write(arquivoPedido);
			arquivoPedido.close();
			System.out.println("arquivo gerado");
			
		}catch(IOException e) {
			
			e.printStackTrace();
			System.out.println("falha ao gerar arquivo");
			
		}
		
	}
	
	public String getDataAtual() {
		
		Date data = new Date();
		Calendar c = Calendar.getInstance();
        data = c.getTime();
        DateFormat formataData = DateFormat.getDateInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
        return sdf.format(data);
	}
	
}
