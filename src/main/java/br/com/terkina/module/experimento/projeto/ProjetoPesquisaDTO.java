package br.com.terkina.module.experimento.projeto;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import br.com.terkina.base.model.Item;
import br.com.terkina.base.model.ItemVO;
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
	
	@JsonTypeInfo(use=Id.NAME, defaultImpl = ItemVO.class)
	private Item tipoPesquisa;
	
	@JsonTypeInfo(use=Id.NAME, defaultImpl = ItemVO.class)
	private Collection<Item> orientadores;
	
	@JsonTypeInfo(use=Id.NAME, defaultImpl = ItemVO.class)
	private Collection<Item> pesquisadores;
	
	@JsonTypeInfo(use=Id.NAME, defaultImpl = ItemVO.class)
	private Collection<Item> animais;	
}