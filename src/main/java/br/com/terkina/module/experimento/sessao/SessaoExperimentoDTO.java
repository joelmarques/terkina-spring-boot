package br.com.terkina.module.experimento.sessao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import br.com.terkina.base.entity.Item;
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
	private Item disciplina;
	private Collection<Item> pesquisadores;
	private Collection<Item> animais;
	private Collection<ArquivoDTO> arquivos = new ArrayList<ArquivoDTO>();
}