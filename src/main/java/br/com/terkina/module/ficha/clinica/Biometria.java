package br.com.terkina.module.ficha.clinica;

import java.math.BigDecimal;
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
@Table(name="BIOMETRIA")
@NoArgsConstructor
@Getter @Setter
public class Biometria {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ID_ANIMAL")
	private Long idAnimal;
	
	@Column(name="DATA", nullable = false)
	private Date data;
	
	@Column(name="PESO")
	private BigDecimal peso;
	
	@Column(name="COMPRIMENTO_CAUDA")
	private BigDecimal comprimentoCauda;
	
	@Column(name="COMPRIMENTO_CORPO")
	private BigDecimal comprimentoCorpo;
	
	@Column(name="SITUACAO", length = 500)
	private String situacao;
}