package br.com.portal.hidrosistemas.output;

import br.com.portal.hidrosistemas.control.Empresa;

public class TestaXLS {

	public static void main(String[] args) {
		
		Empresa emp = new Empresa(1, "abc", "asa", "saas", "asasa", "asaf", "sdasda", "dsas", "dsda", "dsdsa",
				"dsda", "dsdsa", "dsdsad", true, 1);
		
		String[] desc = new String[5];
		String[] qnt = new String[5];
		
		desc[0] = "Item 1";
		desc[1] = "Item 2";
		desc[2] = "Item 3";
		desc[3] = "Item 4";
		desc[4] = "Item 5";
		
		qnt[0] = "1";
		qnt[1] = "1";
		qnt[2] = "1";
		qnt[3] = "1";
		qnt[4] = "1";
		
		WriteXLS teste = new WriteXLS();
		
		teste.escrevePedidoXLS(emp, desc, qnt, 87);
		
		
	}
	
}
