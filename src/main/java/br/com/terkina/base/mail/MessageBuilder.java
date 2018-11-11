package br.com.terkina.base.mail;

import br.com.terkina.module.publico.site.Visitante;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MessageBuilder {
	
	public Message build(String name, String mail, String password) {
		
		String subject = "Seja bem vindo(a) ao www.terkina.com.br";
		
		StringBuilder body = new StringBuilder();
		body.append(name + ",");
		body.append("\n\n" + subject);
		body.append("\n\n" + "Seus dados de acesso são:");
		body.append("\n\n" + "Usuário: " + mail);
		body.append("\n" + "Senha: " + password);
		body.append("\n\n" + "Acesse em: http://www.terkina.com.br");
		
		MessageVO message = new MessageVO();
		message.setSubject(subject);
		message.setTo(new String[] {mail});
		message.setBody(body.toString());
		
		return message;
	}
	
	public Message build(Visitante visitante) {
		
		String subject = "Mensagem do visitante do site : " + visitante.getDescricaoDoSite();
		
		StringBuilder body = new StringBuilder();
		body.append(subject + ":");
		body.append("\n\n" + "Nome: " + visitante.getNome());
		body.append("\n\n" + "E-mail: " + visitante.getEmail());
		body.append("\n\n" + "Mensagem: " + visitante.getMensagem());
		
		MessageVO message = new MessageVO();
		message.setSubject(subject);
		message.setTo(new String[] {visitante.getEmailDoSite()});
		message.setBody(body.toString());
		
		return message;
	}
	
	@NoArgsConstructor
	@Getter @Setter
	public class MessageVO implements Message {
		
		private String subject;
		private String[] to;
		private String body;
	}

}