package br.com.terkina.base.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SituacaoEnum {
	
	HABILITADO("Habilitado", true),
	DESABILITADO("Desabilitado", false);
	
	private String descricao;
	private boolean valor;
	
	private SituacaoEnum(final String descricao, final boolean valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	
	@JsonValue
	public String getDescricao() {
		return descricao;
	}
	
	public boolean getValor() {
		return valor;
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
	
	public static SituacaoEnum parse(boolean valor) {
		
		for (SituacaoEnum situacao : SituacaoEnum.values()) {
			if (situacao.getValor() == valor) {
				return situacao;
			}			
		}
		
		return null;
	}

}