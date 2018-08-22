package br.com.terkina.module.animal;

import java.util.ArrayList;
import java.util.Collection;

import br.com.terkina.base.enums.SituacaoEnum;
import br.com.terkina.base.model.Item;
import br.com.terkina.module.arquivo.ArquivoDTO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AnimalDTO {
	
	private Long id;
	private String nome;
	private String codigo;
	private String dataDeNascimento;
	private Item especie;
	private SexoEnum sexo;
	private SituacaoEnum situacao;
	private Item origem;
	private String dataDeEntrada;
	private Item destino;
	private String dataDeSaida;
	private String causaDaSaida;
	private String descricao;
	private String urlFoto;
	private Collection<ArquivoDTO> arquivos = new ArrayList<ArquivoDTO>();
}