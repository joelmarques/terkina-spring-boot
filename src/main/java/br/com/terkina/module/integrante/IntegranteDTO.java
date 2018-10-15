package br.com.terkina.module.integrante;

import java.util.Collection;

import br.com.terkina.base.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class IntegranteDTO {
	
	private Long id;
	private Long tenancy;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String linkedin;
	private String facebook;
	private String curriculoLattes;
	private String resumo;
	private String urlFoto;
	private String password;
	private Boolean enable;
	private Collection<Item> roles;
	private Collection<Item> cursos;
	private Collection<Item> orientadores;
}