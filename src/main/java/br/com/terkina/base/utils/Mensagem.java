package br.com.terkina.base.utils;

import br.com.terkina.module.publico.site.Visitante;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class Mensagem {
	
	private String de;
	private String para;
	private String comCopia;
	private String comCopiaOculta;
	private String titulo;
	private String mensagem;
	
	public static Mensagem criar(String nome, String email, String username, String password) {
		
		Mensagem mensagem = new Mensagem();
		mensagem.setTitulo("Seja bem vindo(a) a Escola Experimental de Primatas (EEP - UFPA)");
		mensagem.setPara(email);
		
		StringBuilder corpo = new StringBuilder();
		corpo.append(nome + ",");
		corpo.append("\n\n" + mensagem.getTitulo());
		corpo.append("\n\n" + "Seus dados de acesso são:");
		corpo.append("\n\n" + "Usuário: " + username);
		corpo.append("\n" + "Senha: " + password);
		corpo.append("\n\n" + "Acesse em: http://www.terkina.com.br");
		
		mensagem.setMensagem(corpo.toString());
		return mensagem;
	}
	
	public static Mensagem criar(Visitante visitante) {
		Mensagem mensagem = new Mensagem();
		mensagem.setTitulo("Mensagem do visitante do site : " + visitante.getDescricaoDoSite());
		mensagem.setPara(visitante.getEmailDoSite());
		
		StringBuilder corpo = new StringBuilder();
		corpo.append(mensagem.getTitulo() + ":");
		corpo.append("\n\n" + "Nome: " + visitante.getNome());
		corpo.append("\n\n" + "E-mail: " + visitante.getEmail());
		corpo.append("\n\n" + "Mensagem: " + visitante.getMensagem());
		
		mensagem.setMensagem(corpo.toString());
		return mensagem;
	}
	
	public static Mensagem criar(String email, String password) {
		
		Mensagem mensagem = new Mensagem();
		mensagem.setTitulo("Acesso ao www.terkina.com.br");
		mensagem.setPara(email);
		
		StringBuilder corpo = new StringBuilder();
		corpo.append(email + ",");
		corpo.append("\n\n" + mensagem.getTitulo());
		corpo.append("\n\n" + "Seus dados de acesso são:");
		corpo.append("\n\n" + "E-mail: " + email);
		corpo.append("\n" + "Senha: " + password);
		corpo.append("\n\n" + "Acesse em: http://www.terkina.com.br");
		
		mensagem.setMensagem(corpo.toString());
		return mensagem;
	}
	
	public Mensagem enviar() {
		
		EmailUtils.enviar(this);
		return this;
	}

}