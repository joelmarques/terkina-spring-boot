package br.com.terkina.module.experimento.trabalho;

public class TrabalhoAcademicoVO {
	
	private Long id;
	private String tipoTrabalho;
	private String titulo;
	private String autores;
	private String urlArquivo;
	
	public TrabalhoAcademicoVO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Number id) {
		this.id = Long.valueOf(id.longValue());
	}
	
	public String getTipoTrabalho() {
		return tipoTrabalho;
	}
	
	public void setTipoTrabalho(String tipoTrabalho) {
		this.tipoTrabalho = TipoTrabalhoEnum.valueOf(tipoTrabalho).getDescricao();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutores() {
		return autores;
	}
	
	public void setAutores(String autores) {
		this.autores = autores;
	}
	
	public String getUrlArquivo() {
		return urlArquivo;
	}
	
	public void setUrlArquivo(String urlArquivo) {
		this.urlArquivo = urlArquivo;
	}
	
}