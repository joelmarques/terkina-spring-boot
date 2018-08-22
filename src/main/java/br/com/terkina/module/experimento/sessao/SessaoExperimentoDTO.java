package br.com.terkina.module.experimento.sessao;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import br.com.terkina.base.model.Item;
import br.com.terkina.base.model.ItemVO;
import br.com.terkina.module.arquivo.ArquivoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class SessaoExperimentoDTO {
	
	private Long id;
	private Long idProjeto;
	private Date dataSessao;
	private String observacoes;
	
	@JsonTypeInfo(use=Id.NAME, defaultImpl = ItemVO.class)
	private Item disciplina;
	
	@JsonTypeInfo(use=Id.NAME, defaultImpl = ItemVO.class)
	private Collection<Item> pesquisadores;
	
	@JsonTypeInfo(use=Id.NAME, defaultImpl = ItemVO.class)
	private Collection<Item> animais;
	
	@JsonTypeInfo(use=Id.NAME, defaultImpl = ItemVO.class)
	private Collection<ArquivoDTO> arquivos;
}