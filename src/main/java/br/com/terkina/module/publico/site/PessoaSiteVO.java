package br.com.terkina.module.publico.site;

import br.com.terkina.module.publico.site.ISite.IPessoa;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of="id")
public class PessoaSiteVO implements IPessoa {
	
	private Long id;
	private String nome;
	private String resumo;
	private String curriculoLattes;
	private String email;
	private String facebook;
	private String urlFoto;
}