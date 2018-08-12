package br.com.terkina.module.integrante;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import br.com.terkina.base.model.Item;
import br.com.terkina.base.model.ItemVO;
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
	
	@JsonTypeInfo(use=Id.NAME, defaultImpl = ItemVO.class)
	private List<Item> roles;
	
	@JsonTypeInfo(use=Id.NAME, defaultImpl = ItemVO.class)
	private List<Item> cursos;
	
	@JsonTypeInfo(use=Id.NAME, defaultImpl = ItemVO.class)
	private List<Item> orientadores;
}