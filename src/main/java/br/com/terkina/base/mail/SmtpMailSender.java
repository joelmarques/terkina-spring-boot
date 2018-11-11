package br.com.terkina.base.mail;

import java.nio.charset.StandardCharsets;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Component
public class SmtpMailSender {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
    private SpringTemplateEngine templateEngine;

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
	
	public void sendWithTemplate(TemplateMessage message) {
		
		try {
		
			MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
			
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
			
			Context context = new Context();
	        context.setVariables(message.getVariables());
	        String html = templateEngine.process(message.getTemplateName(), context);
	
	        helper.setFrom(mailFrom);
	        helper.setTo(message.getTo());
	        helper.setSubject(message.getSubject());
	        helper.setText(html, true);
	
	        this.javaMailSender.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
