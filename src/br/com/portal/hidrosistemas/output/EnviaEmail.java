package br.com.portal.hidrosistemas.output;

import java.sql.Connection;


import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EnviaEmail {

	Connection con;

//	public EnviaEmail(Connection con) {
//		//this.con = con;
//	}
	
	public void enviaEmailPedido(String destinatario, String msg, String assunto, long numPed) throws EmailException {
		

		  // Create the attachment
		  EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath("PEDIDO "+numPed+".xls");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("pedido");
		  attachment.setName("PEDIDO "+numPed+".xls");

		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName("smtp.terra.com.br");
		  email.setSmtpPort(465);
		  email.setDebug(false);
		  email.setAuthentication("lucas.carravetta@hidrosistemas.com", "cns1076sp");
		  email.setSSLOnConnect(true);
		  email.addTo(destinatario);
		  email.setFrom("lucas.carravetta@hidrosistemas.com", "Lucas Carravetta");
		  email.setSubject(assunto);
		  email.setMsg(msg);

		  // add the attachment
		  email.attach(attachment);

		  // send the email
		  email.send();
	}
	
}
