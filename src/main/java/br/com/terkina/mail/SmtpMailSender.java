package br.com.terkina.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SmtpMailSender {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.from}")
	private String mailFrom;
	
	public void send(Message message) {
		
		try {

			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom(mailFrom);
			simpleMailMessage.setTo(message.getTo());
			simpleMailMessage.setSubject(message.getSubject());
			simpleMailMessage.setText(message.getBody());

			this.javaMailSender.send(simpleMailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
