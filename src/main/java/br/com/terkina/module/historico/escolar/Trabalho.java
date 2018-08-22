package br.com.terkina.module.historico.escolar;

import br.com.terkina.module.experimento.trabalho.TrabalhoAcademico;
import br.com.terkina.module.historico.escolar.IHistoricoEscolar.ITrabalho;
import lombok.Getter;

@Getter
public class Trabalho implements ITrabalho {
	
	private String titulo;
	private String urlArquivo;
	
	public Trabalho(final TrabalhoAcademico trabalho) {
		super();
		this.titulo = trabalho.getTitulo();
		this.urlArquivo = trabalho.getUrlArquivo();
	}
}