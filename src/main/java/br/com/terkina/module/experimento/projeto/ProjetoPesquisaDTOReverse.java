package br.com.terkina.module.experimento.projeto;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.terkina.base.converter.Reverse;
import br.com.terkina.base.model.Item;
import br.com.terkina.module.animal.Animal;
import br.com.terkina.module.animal.AnimalDao;
import br.com.terkina.module.integrante.Integrante;
import br.com.terkina.module.integrante.IntegranteDao;
import br.com.terkina.module.tipopesquisa.TipoDePesquisa;
import br.com.terkina.module.tipopesquisa.TipoDePesquisaDao;

@Component
public class ProjetoPesquisaDTOReverse implements Reverse<ProjetoPesquisaDTO, ProjetoPesquisa> {
	
	@Autowired
	private ProjetoPesquisaDao projetoPesquisaDao;
	
	@Autowired
	private TipoDePesquisaDao tipoDePesquisaDao;
	
	@Autowired
	private IntegranteDao integranteDao;
	
	@Autowired
	private AnimalDao animalDao;
	
	@Override
	public ProjetoPesquisa revert(ProjetoPesquisaDTO source) {
		
		ProjetoPesquisa target = this.getProjetoPesquisa(source.getId());
		target.setTitulo(source.getTitulo());
		target.setResumo(source.getResumo());
		target.setDataDeInicio(source.getDataDeInicio());
		target.setDataDeConclusao(source.getDataDeConclusao());
		target.setTipoPesquisa(this.reverterTipoPesquisa(source.getTipoPesquisa()));
		target.setOrientadores(new HashSet<Integrante>(this.integranteDao.findAllById(Item.findIds(source.getOrientadores()))));
		target.setPesquisadores(new HashSet<Integrante>(this.integranteDao.findAllById(Item.findIds(source.getPesquisadores()))));
		target.setAnimais(new HashSet<Animal>(this.animalDao.findAllById(Item.findIds(source.getAnimais()))));
		return target;
	}
	
	private ProjetoPesquisa getProjetoPesquisa(final Long id) {		
		return id == null ? new ProjetoPesquisa() : this.projetoPesquisaDao.getOne(id);
	}
	
	private TipoDePesquisa reverterTipoPesquisa(Item item) {
		return item == null ? null : this.tipoDePesquisaDao.getOne(item.getId());
	}

}