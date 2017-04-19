package com.teste;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author F\u00E1bio Roseno
 */
public class EnvioDeEmail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("fabioroseno@softsite.com.br", "s0fts1t3");
					}
				});

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("fabioroseno@softsite.com.br")); // Remetente

			Address[] toUser = InternetAddress.parse("fabioroseno@softsite.com.br");// Destinatário(s)

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Testando Configurações");// Assunto
			message.setText("Este é um email enviado pelo Portal GeoSales para testar suas Configurações de recebimento de e-mails em caso de Falha na Importação!");
			
			/** Método para enviar a mensagem criada */
			Transport.send(message);

		} catch (AddressException e) {  
			throw new RuntimeException(e);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
