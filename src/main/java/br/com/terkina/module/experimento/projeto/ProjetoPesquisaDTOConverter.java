package br.com.terkina.module.experimento.projeto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.terkina.base.converter.Converter;
import br.com.terkina.base.model.Item;
import br.com.terkina.module.animal.Animal;
import br.com.terkina.module.animal.AnimalDTOConverter;
import br.com.terkina.module.integrante.Integrante;
import br.com.terkina.module.integrante.IntegranteDTOConverter;
import br.com.terkina.module.tipopesquisa.TipoDePesquisa;

@Component
public class ProjetoPesquisaDTOConverter implements Converter<ProjetoPesquisa, ProjetoPesquisaDTO> {
	
	@Autowired
	private IntegranteDTOConverter integranteDTOConverter;
	
	@Autowired
	private AnimalDTOConverter animalDTOConverter;

	@Override
	public ProjetoPesquisaDTO convert(final ProjetoPesquisa source) {
		
		ProjetoPesquisaDTO target = new ProjetoPesquisaDTO();
		target.setId(source.getId());
		target.setTitulo(source.getTitulo());
		target.setResumo(source.getResumo());
		target.setDataDeInicio(source.getDataDeInicio());
		target.setDataDeConclusao(source.getDataDeConclusao());
		target.setTipoPesquisa(this.converterTipoDePesquisa(source.getTipoPesquisa()));
		target.setOrientadores(this.converterIntegrantes(source.getOrientadores()));
		target.setPesquisadores(this.converterIntegrantes(source.getPesquisadores()));
		target.setAnimais(this.converterAnimais(source.getAnimais()));
		
		return target;
	}
	
	private Item converterTipoDePesquisa(final TipoDePesquisa item) {
		return item == null ? null : Item.create(item.getId(), item.getNome());
	}

	private Collection<Item> converterIntegrantes(final Collection<Integrante> itens) {
		return this.integranteDTOConverter.converterIntegrantes(itens);
	}
	
	private Collection<Item> converterAnimais(final Collection<Animal> itens) {
		return this.animalDTOConverter.converterAnimais(itens);
	}
}