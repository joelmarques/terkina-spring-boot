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
@Table(name="HISTORICO_CLINICO")
@NoArgsConstructor
@Getter @Setter
public class HistoricoClinico {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ID_ANIMAL")
	private Long idAnimal;
	
	@Column(name="DATA", nullable = false)
	private Date data;
	
	@Column(name="DIAGNOSTICO")
	private String diagnostico;
	
	@Column(name="PERIODO_TRATAMENTO")
	private String periodoDeTratamento;
	
	@Column(name="RESULTADO")
	private String resultado;	
}