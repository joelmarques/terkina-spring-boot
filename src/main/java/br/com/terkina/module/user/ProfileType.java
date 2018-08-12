package br.com.terkina.module.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProfileType {
	
	ADMIN("Administrador"),
	ORIENTADOR("Orientador"),
	PESQUISADOR("Pesquisador"),
	VETERINARIA("Veterinária"),
	TRATADOR("Tratador");
	
	private String id;
	private String descricao;
	
	private ProfileType(String descricao) {
		this.id = this.name();
		this.descricao = descricao;
	}

	public String getId() {
		return id;
	}
	
	@JsonValue
	public String getDescricao() {
		return descricao;
	}
	
	@JsonCreator
	public static ProfileType getAsObject(String descricao) {
		
		for (ProfileType role : ProfileType.values()) {
			if (role.getDescricao().equalsIgnoreCase(descricao)) {
				return role;
			}
		}
		
		return null;
	}

}