package br.com.terkina.module.animal;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.terkina.base.converter.Reverse;
import br.com.terkina.base.model.ItemVO;
import br.com.terkina.base.utils.DateUtils;
import br.com.terkina.module.arquivo.Arquivo;
import br.com.terkina.module.arquivo.ArquivoDTO;
import br.com.terkina.module.arquivo.ArquivoDTOReverse;
import br.com.terkina.module.localizacao.Localizacao;
import br.com.terkina.module.localizacao.LocalizacaoDao;
import br.com.terkina.module.tipoanimal.TipoDeAnimal;
import br.com.terkina.module.tipoanimal.TipoDeAnimalDao;

@Component
public class AnimalDTOReverse implements Reverse<AnimalDTO, Animal> {
	
	@Autowired
	private AnimalDao animalDao;
	
	@Autowired
	private TipoDeAnimalDao tipoDeAnimalDao;
	
	@Autowired
	private LocalizacaoDao localizacaoDao;
	
	@Autowired
	private ArquivoDTOReverse arquivoDTOReverse;
	
	@Override
	public Animal revert(AnimalDTO source) {
		
		Animal target = this.getAnimal(source.getId());
		target.setNome(source.getNome());
		target.setCodigo(source.getCodigo());
		target.setDataDeNascimento(DateUtils.parse(source.getDataDeNascimento()));
		target.setTipoDeAnimal(this.reverterEspecie(source.getEspecie()));
		target.setSexo(source.getSexo());
		target.setSituacao(source.getSituacao());
		target.setOrigem(this.reverterOrigem(source.getOrigem()));
		target.setDataDeEntrada(DateUtils.parse(source.getDataDeEntrada()));
		target.setDestino(this.reverterDestino(source.getDestino()));
		target.setDataDeSaida(DateUtils.parse(source.getDataDeSaida()));
		target.setCausaDaSaida(source.getCausaDaSaida());
		target.setDescricao(source.getDescricao());
		target.setUrlFoto(source.getUrlFoto());
		target.setArquivos(this.reverterArquivos(source.getArquivos()));
		return target;
	}
	
	private Animal getAnimal(final Long id) {		
		return id == null ? new Animal() : this.animalDao.getOne(id);
	}
	
	private TipoDeAnimal reverterEspecie(final ItemVO source) {
		return source == null ? null : this.tipoDeAnimalDao.getOne(source.getId());
	}

	private Localizacao reverterOrigem(final ItemVO source) {
		return source == null ? null : this.localizacaoDao.getOne(source.getId());
	}

	private Localizacao reverterDestino(final ItemVO source) {
		return source == null ? null : this.localizacaoDao.getOne(source.getId());
	}
	
	private Set<Arquivo> reverterArquivos(final Collection<ArquivoDTO> arquivos) {
		return this.arquivoDTOReverse.revert(arquivos);
	}
}