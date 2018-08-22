package br.com.terkina.module.experimento.trabalho;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.terkina.base.converter.Reverse;
import br.com.terkina.module.experimento.projeto.ProjetoPesquisa;
import br.com.terkina.module.experimento.projeto.ProjetoPesquisaDao;

@Component
public class TrabalhoAcademicoDTOReverse implements Reverse<TrabalhoAcademicoDTO, TrabalhoAcademico> {
	
	@Autowired
	private TrabalhoAcademicoDao trabalhoAcademicoDao;
	
	@Autowired
	private ProjetoPesquisaDao projetoPesquisaDao;

	@Override
	public TrabalhoAcademico revert(TrabalhoAcademicoDTO source) {
		
		TrabalhoAcademico target = this.getTrabalhoAcademico(source.getId());
		target.setProjeto(this.reverterProjeto(target.getProjeto(), source.getIdProjeto()));
		target.setTipoTrabalho(source.getTipoTrabalho());
		target.setNatureza(source.getNatureza());
		target.setNaturezaEvento(source.getNaturezaEvento());
		target.setNomePeriodico(source.getNomePeriodico());
		target.setVolume(source.getVolume());
		target.setEdicao(source.getEdicao());
		target.setPaginaInicial(source.getPaginaInicial());
		target.setTitulo(source.getTitulo());
		target.setPalavrasChave(source.getPalavrasChave());
		target.setAno(source.getAno());
		target.setEvento(source.getEvento());
		target.setCidadeEvento(source.getCidadeEvento());
		target.setOrientador(source.getOrientador());
		target.setAutores(source.getAutores());
		target.setUrlArquivo(source.getUrlArquivo());
		target.setObservacoes(source.getObservacoes());
		return target;
	}
	
	private TrabalhoAcademico getTrabalhoAcademico(final Long id) {
		return id == null ? new TrabalhoAcademico() : this.trabalhoAcademicoDao.getOne(id);
	}
	
	private ProjetoPesquisa reverterProjeto(final ProjetoPesquisa projeto, final Long idProjeto) {
		return Optional.ofNullable(projeto).orElse(this.projetoPesquisaDao.getOne(idProjeto));
	}

}