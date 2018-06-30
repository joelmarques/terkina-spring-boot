package br.com.terkina.module.arquivo;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoArquivoEnum {
	
	IMAGEM("Imagem"),
	VIDEO("Vídeo"),
	ARQUIVO("Arquivo");
	
	private String descricao;
	
	private TipoArquivoEnum(final String descricao) {
		this.descricao = descricao;
	}
	
	@JsonValue
	public String getDescricao() {
		return descricao;
	}
	
	@JsonCreator
	public static TipoArquivoEnum getAsObject(String descricao) {
		
		for (TipoArquivoEnum tipo : TipoArquivoEnum.values()) {
			if (StringUtils.equalsIgnoreCase(tipo.getDescricao(), descricao)) {
				return tipo;
			}
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return this.getDescricao();
	}

}