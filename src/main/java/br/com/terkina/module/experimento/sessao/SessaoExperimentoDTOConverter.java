package br.com.terkina.module.experimento.sessao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.terkina.base.converter.Converter;
import br.com.terkina.base.model.Item;
import br.com.terkina.module.animal.AnimalDTOConverter;
import br.com.terkina.module.arquivo.ArquivoDTOConverter;
import br.com.terkina.module.disciplina.Disciplina;
import br.com.terkina.module.integrante.IntegranteDTOConverter;

@Component
public class SessaoExperimentoDTOConverter implements Converter<SessaoExperimento, SessaoExperimentoDTO> {
	
	@Autowired
	private IntegranteDTOConverter integranteDTOConverter;
	
	@Autowired
	private AnimalDTOConverter animalDTOConverter;
	
	@Autowired
	private ArquivoDTOConverter arquivoDTOConverter;

	@Override
	public SessaoExperimentoDTO convert(SessaoExperimento source) {
		
		SessaoExperimentoDTO target = new SessaoExperimentoDTO();
		target.setId(source.getId());
		target.setDisciplina(this.converterDisciplina(source.getDisciplina()));
		target.setDataSessao(source.getDataSessao());
		target.setObservacoes(source.getObservacoes());
		target.setPesquisadores(this.integranteDTOConverter.converterIntegrantes(source.getPesquisadores()));
		target.setAnimais(this.animalDTOConverter.converterAnimais(source.getAnimais()));
		target.setArquivos(this.arquivoDTOConverter.convert(source.getArquivos()));
		
		return target;
	}

	private Item converterDisciplina(final Disciplina disciplina) {
		return disciplina == null ? null : Item.create(disciplina.getId(), disciplina.getNome());
	}
}