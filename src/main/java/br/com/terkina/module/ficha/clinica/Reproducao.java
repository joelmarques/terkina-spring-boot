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
@Table(name="REPRODUCAO")
@NoArgsConstructor
@Getter @Setter
public class Reproducao {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ID_ANIMAL")
	private Long idAnimal;
	
	@Column(name="DATA", nullable = false)
	private Date data;
	
	@Column(name="OCORRENCIA")
	private String ocorrencia;
}