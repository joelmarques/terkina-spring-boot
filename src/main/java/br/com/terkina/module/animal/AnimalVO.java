package br.com.terkina.module.animal;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AnimalVO {
	
	private Long id;
	private String nome;
	private String codigo;
	private String sexo;
	private String especie;
	private String proveniencia;
	private String dataDeNascimento;
	private String situacao;
	private String urlFoto;
}