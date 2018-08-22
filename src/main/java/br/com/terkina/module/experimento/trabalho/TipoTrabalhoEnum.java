package br.com.terkina.module.experimento.trabalho;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoTrabalhoEnum {
	
	ARTIGO_PUBLICADO_EM_PERIODICO("1", "Artigo publicado em periódico") {
		@Override
		public List<NaturezaEnum> getNaturezas() {return null;}

		@Override
		public List<NaturezaEventoEnum> getNaturezasEvento() {return null;}
	}, 
	TRABALHO_PUBLICADO_EM_ANAIS_DE_EVENTOS("2", "Trabalho publicado em anais de eventos") {
		@Override
		public List<NaturezaEnum> getNaturezas() {
			return Arrays.asList(NaturezaEnum.COMPLETO, NaturezaEnum.RESUMO, NaturezaEnum.RESUMO_EXPANDIDO);
		}

		@Override
		public List<NaturezaEventoEnum> getNaturezasEvento() {
			return Arrays.asList(NaturezaEventoEnum.INTERNACIONAL, NaturezaEventoEnum.NACIONAL, NaturezaEventoEnum.REGIONAL_OU_LOCAL);
		}
	}, 
	APRESENTACAO_DE_TRABALHO_OU_PALESTRA("3", "Apresentação de trabalho ou palestra") {
		@Override
		public List<NaturezaEnum> getNaturezas() {
			return Arrays.asList(NaturezaEnum.COMUNICACAO, NaturezaEnum.CONFERENCIA_OU_PALESTRA, NaturezaEnum.CONGRESSO,
								 NaturezaEnum.SEMINARIO, NaturezaEnum.SIMPOSIO, NaturezaEnum.OUTRA);
		}

		@Override
		public List<NaturezaEventoEnum> getNaturezasEvento() {
			return Arrays.asList(NaturezaEventoEnum.INTERNACIONAL, NaturezaEventoEnum.NACIONAL, NaturezaEventoEnum.REGIONAL_OU_LOCAL);
		}
	}, 
	TESES_DISSERTACOES_E_MONOGRAFIAS("4", "Teses, dissertações e monografias") {
		@Override
		public List<NaturezaEnum> getNaturezas() {
			return Arrays.asList(NaturezaEnum.TESE, NaturezaEnum.DISSERTACAO, NaturezaEnum.MONOGRAFIA);
		}

		@Override
		public List<NaturezaEventoEnum> getNaturezasEvento() {return null;}
	};
	
	private String id;
	private String descricao;
	
	private TipoTrabalhoEnum(final String id, final String descricao){
		this.id = id;
		this.descricao = descricao;
	}
	
	public String getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	@SuppressWarnings("unchecked")
	public static TipoTrabalhoEnum getAsObject(Object object) {
		
		if (object instanceof TipoTrabalhoEnum) {
			return (TipoTrabalhoEnum)object;
		}
		
		LinkedHashMap<String, Object> tipoTrabalho = (LinkedHashMap<String, Object>) object;
		
		for (TipoTrabalhoEnum tipo : TipoTrabalhoEnum.values()) {
			if (tipo.getId().equalsIgnoreCase((String)tipoTrabalho.get("id"))) {
				return tipo;
			}
		}
		
		return null;
	}
	
	public abstract List<NaturezaEnum> getNaturezas();
	public abstract List<NaturezaEventoEnum> getNaturezasEvento();

}