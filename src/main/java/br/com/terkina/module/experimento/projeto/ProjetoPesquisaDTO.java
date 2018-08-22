package br.com.terkina.module.experimento.projeto;

import java.util.Collection;
import java.util.Date;

import br.com.terkina.base.model.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class ProjetoPesquisaDTO {
	
	private Long id;
	private String titulo;
	private String resumo;
	private Date dataDeInicio;
	private Date dataDeConclusao;
	private Item tipoPesquisa;
	private Collection<Item> orientadores;
	private Collection<Item> pesquisadores;
	private Collection<Item> animais;	
}