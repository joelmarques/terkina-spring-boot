package br.com.terkina.module.experimento.trabalho;

import org.springframework.stereotype.Component;

import br.com.terkina.base.converter.Converter;

@Component
public class TrabalhoAcademicoDTOConverter implements Converter<TrabalhoAcademico, TrabalhoAcademicoDTO> {
	
	@Override
	public TrabalhoAcademicoDTO convert(TrabalhoAcademico source) {
		
		TrabalhoAcademicoDTO target = new TrabalhoAcademicoDTO();
		target.setId(source.getId());
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

}