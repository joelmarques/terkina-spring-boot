package br.com.terkina.module.arquivo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class ArquivoDTO {
	
	private Long id;
	
	private String descricao;
	
	private String urlArquivo;
	
	private TipoArquivoEnum tipo;
	
	public ArquivoDTO(Arquivo arquivo) {
		super();
		this.id = arquivo.getId();
		this.descricao = arquivo.getDescricao();
		this.urlArquivo = arquivo.getUrlArquivo();
		this.tipo = arquivo.getTipo();
	}
}