package br.com.terkina.module.animal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SituacaoEnum {
	
	HABILITADO("Habilitado"),
	DESABILITADO("Desabilitado");
	
	private String descricao;
	
	private SituacaoEnum(final String descricao) {
		this.descricao = descricao;
	}
	
	@JsonValue
	public String getDescricao() {
		return descricao;
	}
	
	@JsonCreator
	public static SituacaoEnum getAsObject(String descricao) {
		
		for (SituacaoEnum situacao : SituacaoEnum.values()) {
			if (situacao.getDescricao().equalsIgnoreCase(descricao)) {
				return situacao;
			}
		}
		
		return null;
	}

}