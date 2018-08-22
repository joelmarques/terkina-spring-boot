package br.com.terkina.module.experimento.trabalho;

public class TrabalhoAcademicoDTO {
	
	private Long id;
	private Long idProjeto;
	private TipoTrabalhoEnum tipoTrabalho;
	private NaturezaEnum natureza;
	private NaturezaEventoEnum naturezaEvento;
	private String nomePeriodico;
	private String volume;
	private String edicao;
	private String paginaInicial;
	private String titulo;
	private String palavrasChave;
	private Integer ano;
	private String evento;
	private String cidadeEvento;
	private String orientador;
	private String autores;
	private String urlArquivo;
	private String observacoes;
	
	public TrabalhoAcademicoDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIdProjeto() {
		return idProjeto;
	}
	
	public void setIdProjeto(Long idProjeto) {
		this.idProjeto = idProjeto;
	}

	public TipoTrabalhoEnum getTipoTrabalho() {
		return tipoTrabalho;
	}

	public void setTipoTrabalho(Object object) {		
		this.tipoTrabalho = TipoTrabalhoEnum.getAsObject(object);
	}
	
	public NaturezaEnum getNatureza() {
		return natureza;
	}

	public void setNatureza(NaturezaEnum natureza) {
		this.natureza = natureza;
	}

	public NaturezaEventoEnum getNaturezaEvento() {
		return naturezaEvento;
	}

	public void setNaturezaEvento(NaturezaEventoEnum naturezaEvento) {
		this.naturezaEvento = naturezaEvento;
	}

	public String getNomePeriodico() {
		return nomePeriodico;
	}

	public void setNomePeriodico(String nomePeriodico) {
		this.nomePeriodico = nomePeriodico;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getPaginaInicial() {
		return paginaInicial;
	}

	public void setPaginaInicial(String paginaInicial) {
		this.paginaInicial = paginaInicial;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPalavrasChave() {
		return palavrasChave;
	}

	public void setPalavrasChave(String palavrasChave) {
		this.palavrasChave = palavrasChave;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getCidadeEvento() {
		return cidadeEvento;
	}

	public void setCidadeEvento(String cidadeEvento) {
		this.cidadeEvento = cidadeEvento;
	}

	public String getOrientador() {
		return orientador;
	}

	public void setOrientador(String orientador) {
		this.orientador = orientador;
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

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
}