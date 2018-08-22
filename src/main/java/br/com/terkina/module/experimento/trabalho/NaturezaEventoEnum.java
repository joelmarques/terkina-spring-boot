package br.com.terkina.module.experimento.trabalho;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum NaturezaEventoEnum {
	
	INTERNACIONAL("Internacional"),
	NACIONAL("Nacional"),
	REGIONAL_OU_LOCAL("Regional ou local");
	
	private String descricao;
	
	private NaturezaEventoEnum(String descricao) {
		this.descricao = descricao;
	}

	@JsonValue
	public String getDescricao() {
		return descricao;
	}
	
	@JsonCreator
	public static NaturezaEventoEnum getAsObject(String descricao) {
		
		for (NaturezaEventoEnum tipo : NaturezaEventoEnum.values()) {
			if (tipo.getDescricao().equalsIgnoreCase(descricao)) {
				return tipo;
			}
		}
		
		return null;
	}

}