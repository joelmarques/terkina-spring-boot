package br.com.terkina.module.historico.escolar;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import br.com.terkina.base.utils.DateUtils;
import br.com.terkina.module.experimento.projeto.ProjetoPesquisa;
import br.com.terkina.module.historico.escolar.IHistoricoEscolar.IProjeto;
import br.com.terkina.module.historico.escolar.IHistoricoEscolar.ITrabalho;
import lombok.Getter;

@Getter
public class Projeto implements IProjeto {
	
	private static final String ATUAL = "Atual";
	private static final String ORIENTADOR = " (orientador)";
	private static final String PESQUISADOR = " (pesquisador)";
	
	private String inicio;
	private String fim;
	private String titulo;
	private String resumo;
	private Collection<String> integrantes;
	private Collection<String> disciplinasCursadas;
	private Collection<ITrabalho> trabalhosPublicados;
	
	public Projeto(final ProjetoPesquisa projeto) {
		super();
		this.inicio = DateUtils.formatYear(projeto.getDataDeInicio());
		this.fim = StringUtils.defaultString(DateUtils.formatYear(projeto.getDataDeConclusao()), ATUAL);
		this.titulo = projeto.getTitulo();
		this.resumo = projeto.getResumo();
		this.integrantes = this.converterIntegrantes(projeto);
		this.disciplinasCursadas = this.converterDisciplinas(projeto);
		this.trabalhosPublicados = this.converterTrabalhos(projeto);
	}
	
	private Collection<String> converterIntegrantes(final ProjetoPesquisa projeto) {
		Stream<String> orientadores = projeto.getOrientadores().stream().map(i -> i.getNome() + ORIENTADOR);
		Stream<String> pesquisadores = projeto.getPesquisadores().stream().map(i -> i.getNome() + PESQUISADOR);
		return Stream.concat(orientadores, pesquisadores).collect(Collectors.toSet());
	}
	
	private Collection<String> converterDisciplinas(final ProjetoPesquisa projeto) {
		return projeto.getSessoesExperimento().stream().map(s -> Objects.toString(s.getDisciplina())).collect(Collectors.toSet());
	}

	private Collection<ITrabalho> converterTrabalhos(final ProjetoPesquisa projeto) {
		return projeto.getTrabalhosAcademicos().stream().map(Trabalho::new).collect(Collectors.toList());
	}
}