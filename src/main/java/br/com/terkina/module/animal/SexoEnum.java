package br.com.terkina.module.animal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SexoEnum {
	
	MACHO("Macho"),
	FEMEA("Fêmea");
	
	private String descricao;
	
	private SexoEnum(final String descricao) {
		this.descricao = descricao;
	}
	
	@JsonValue
	public String getDescricao() {
		return descricao;
	}
	
	@JsonCreator
	public static SexoEnum getAsObject(String descricao) {
		
		for (SexoEnum sexo : SexoEnum.values()) {
			if (sexo.getDescricao().equalsIgnoreCase(descricao)) {
				return sexo;
			}
		}
		
		return null;
	}
	
	public static String getAsString(String name) {
		
		for (SexoEnum sexo : SexoEnum.values()) {
			if (sexo.name().equalsIgnoreCase(name)) {
				return sexo.getDescricao();
			}
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return this.getDescricao();
	}
	
	
}