package br.com.terkina.module.experimento.projeto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class ProjetoPesquisaVO {
	private Long id;	
	private String titulo;	
	private String tipoPesquisa;
}