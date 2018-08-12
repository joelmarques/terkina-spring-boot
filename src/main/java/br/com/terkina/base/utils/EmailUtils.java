package br.com.terkina.base.utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailUtils {

	private static final String HOSTNAME = "smtp.gmail.com";
	private static final int PORTA = 465;
	private static final boolean SSL = true;
	private static final String USERNAME = "terkina.teste@gmail.com";
	private static final String PASSWORD = "2018anikret";
	private static final String EMAILORIGEM = "terkina.teste@gmail.com";

	public static void enviar(Mensagem mensagem) {

		try {
			
			Email email = new SimpleEmail();
			email.setHostName(HOSTNAME);
			email.setSmtpPort(PORTA);
			email.setAuthenticator(new DefaultAuthenticator(USERNAME, PASSWORD));
			email.setSSLOnConnect(SSL);
			email.setFrom(EMAILORIGEM);			
			email.setSubject(mensagem.getTitulo());
			email.setMsg(mensagem.getMensagem());
			email.addTo(mensagem.getPara());
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}