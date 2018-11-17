package br.com.portal.hidrosistemas.output;

import java.sql.Connection;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class EnviaEmail {

	Connection con;

//	public EnviaEmail(Connection con) {
//		//this.con = con;
//	}
	
	public void enviaEmailPedido(String destinatario, String msg, String assunto, long numPed) throws EmailException {
		
//		Email email = new SimpleEmail();
//		email.setHostName("smtp.gmail.com");
//		email.setSmtpPort(465);
//		email.setDebug(true);
//		email.setAuthentication("lscarravetta@gmail.com", "34785081");
//		email.setSSLOnConnect(true);
//		email.setFrom("lscarravetta@gmail.com", "Lucas Carravetta");
//		email.setSubject(assunto);
//		email.setMsg(msg);
//		email.addTo(destinatario);
//		email.send();
		

		  // Create the attachment
		  EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath("PEDIDO "+numPed+".xls");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("pedido");
		  attachment.setName("PEDIDO "+numPed+".xls");

		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName("smtp.gmail.com");
		  email.setSmtpPort(465);
		  email.setDebug(true);
		  email.setAuthentication("lscarravetta@gmail.com", "34785081");
		  email.setSSLOnConnect(true);
		  email.addTo(destinatario);
		  email.setFrom("lscarravetta@gmail.com", "Lucas Carravetta");
		  email.setSubject(assunto);
		  email.setMsg(msg);

		  // add the attachment
		  email.attach(attachment);

		  // send the email
		  email.send();
	}
	
}
