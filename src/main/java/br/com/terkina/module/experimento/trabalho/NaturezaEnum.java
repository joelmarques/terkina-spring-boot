package br.com.terkina.module.experimento.trabalho;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum NaturezaEnum {
	
	COMPLETO("Completo"),
	RESUMO("Resumo"),
	RESUMO_EXPANDIDO("Resumo expandido"),
	COMUNICACAO("Comunicação"),
	CONFERENCIA_OU_PALESTRA("Conferência ou palestra"),
	CONGRESSO("Congresso"),
	SEMINARIO("Seminário"),
	SIMPOSIO("Simpósio"),
	OUTRA("Outra"),
	TESE("Tese"),
	DISSERTACAO("Dissertação"),
	MONOGRAFIA("Monografia");
	
	private String descricao;
	
	private NaturezaEnum(String descricao) {
		this.descricao = descricao;
	}

	@JsonValue
	public String getDescricao() {
		return descricao;
	}
	
	@JsonCreator
	public static NaturezaEnum getAsObject(String descricao) {
		
		for (NaturezaEnum tipo : NaturezaEnum.values()) {
			if (tipo.getDescricao().equalsIgnoreCase(descricao)) {
				return tipo;
			}
		}
		
		return null;
	}
	
}