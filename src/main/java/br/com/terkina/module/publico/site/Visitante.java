package br.com.terkina.module.publico.site;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Visitante {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "DATA_CADASTRO", nullable = false)
	private Date dataCadastro;
	
	@Column(name="NOME", length = 100, nullable = false)
	private String nome;
	
	@Column(name="EMAIL", length = 100, nullable = false)
	private String email;
	
	@Column(name="MENSAGEM", length = 300, nullable = false)
	private String mensagem;
	
	@Column(name="IDENTIFICADOR_SITE", length = 30, nullable = false)
	private String identificadorDoSite;
	
	@Column(name="EMAIL_SITE", length = 100, nullable = false)
	private String emailDoSite;
	
	@Column(name="DESCRICAO_SITE", length = 50, nullable = false)
	private String descricaoDoSite;
	
	public Visitante cadastradoHoje() {
		this.dataCadastro = new Date();
		return this;
	}
	
}