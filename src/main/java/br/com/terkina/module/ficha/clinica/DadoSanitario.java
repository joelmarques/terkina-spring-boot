package br.com.terkina.module.ficha.clinica;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="DADO_SANITARIO")
@NoArgsConstructor
@Getter @Setter
public class DadoSanitario {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ID_ANIMAL")
	private Long idAnimal;
	
	@Column(name="DATA", nullable = false)
	private Date data;
	
	@Column(name="RESULTADO")
	private String resultado;
	
	@Column(name="VERMIFUGO_UTILIZADO")
	private String vermifugoUtilizado;
	
	@Column(name="DATA_VERMIFUGACAO")
	private Date dataVermifugacao;
}