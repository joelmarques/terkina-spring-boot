package br.com.terkina.module.integrante;

import java.util.List;

import br.com.terkina.base.model.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class IntegranteVO {
	
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private List<Item> roles;
	private List<Item> orientadores;
	private Boolean enable;
}