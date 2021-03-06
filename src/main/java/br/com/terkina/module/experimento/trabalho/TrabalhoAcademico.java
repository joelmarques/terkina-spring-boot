package br.com.terkina.module.experimento.trabalho;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import br.com.terkina.base.entity.AbstractEntity;
import br.com.terkina.module.experimento.projeto.ProjetoPesquisa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TRABALHO_ACADEMICO")
@NoArgsConstructor
@Getter @Setter
@NamedNativeQueries({
	@NamedNativeQuery(name="TrabalhoAcademico.buscarTrabalhosAcademicosPorProjeto",
			  		  query="select t.id as id, t.titulo as titulo, t.autores as autores,"
			  		  		+ " t.evento as evento, t.url_arquivo as urlArquivo"
			  		  		+ " from trabalho_academico t"
			  		  		+ " where t.id_projeto = ?1")
	
})
public class TrabalhoAcademico extends AbstractEntity<Long> {
	
	private static final long serialVersionUID = 3193641982372633466L;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PROJETO", nullable=false)
	private ProjetoPesquisa projeto;
	
	@Enumerated(EnumType.STRING)
	@Column(name="TIPO_TRABALHO")
	private TipoTrabalhoEnum tipoTrabalho;
	
	@Enumerated(EnumType.STRING)
	@Column(name="NATUREZA")
	private NaturezaEnum natureza;
	
	@Enumerated(EnumType.STRING)
	@Column(name="NATUREZA_EVENTO")
	private NaturezaEventoEnum naturezaEvento;
	
	@Column(name="NOME_PERIODICO")
	private String nomePeriodico;
	
	@Column(name="VOLUME")
	private String volume;
	
	@Column(name="EDICAO")
	private String edicao;
	
	@Column(name="PAGINA_INICIAL")
	private String paginaInicial;
	
	@Column(name="TITULO")
	private String titulo;
	
	@Column(name="PALAVRAS_CHAVE")
	private String palavrasChave;
	
	@Column(name="ANO")
	private Integer ano;
	
	@Column(name="EVENTO")
	private String evento;
	
	@Column(name="CIDADE_EVENTO")
	private String cidadeEvento;
	
	@Column(name="ORIENTADOR")
	private String orientador;
	
	@Column(name="AUTORES")
	private String autores;
	
	@Column(name="URL_ARQUIVO", length = 300)
	private String urlArquivo;
	
	@Column(name="OBSERVACOES", length = 1000)
	private String observacoes;
	
}