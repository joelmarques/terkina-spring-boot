package br.com.terkina.module.animal;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.terkina.base.converter.Reverse;
import br.com.terkina.base.entity.Item;
import br.com.terkina.base.utils.DateUtils;
import br.com.terkina.module.arquivo.Arquivo;
import br.com.terkina.module.arquivo.ArquivoDTO;
import br.com.terkina.module.arquivo.ArquivoDTOReverse;
import br.com.terkina.module.localizacao.Localizacao;
import br.com.terkina.module.localizacao.LocalizacaoDao;
import br.com.terkina.module.tipoanimal.TipoDeAnimal;
import br.com.terkina.module.tipoanimal.TipoDeAnimalDao;
import br.com.terkina.module.user.UserService;

@Component
public class AnimalDTOReverse implements Reverse<AnimalDTO, Animal> {
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private TipoDeAnimalDao tipoDeAnimalDao;
	
	@Autowired
	private LocalizacaoDao localizacaoDao;
	
	@Autowired
	private ArquivoDTOReverse arquivoDTOReverse;
	
	@Autowired
	private UserService userService;
	
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
		this.definirTenancy(target);
		return target;
	}
	
	private void definirTenancy(Animal animal) {
		
		Long tenancy = this.userService.getCurrentTenancy();
		
		animal.setTenancy(tenancy);
		
		if (animal.getArquivos() != null) {
			for (Arquivo  arquivo : animal.getArquivos()) {
				arquivo.setTenancy(tenancy);
			}
		}
	}

	private Animal getAnimal(final Long id) {		
		return id == null ? new Animal() : this.animalRepository.getOne(id);
	}
	
	private TipoDeAnimal reverterEspecie(final Item source) {
		return source == null ? null : this.tipoDeAnimalDao.getOne(source.getId());
	}

	private Localizacao reverterOrigem(final Item source) {
		return source == null ? null : this.localizacaoDao.getOne(source.getId());
	}

	private Localizacao reverterDestino(final Item source) {
		return source == null ? null : this.localizacaoDao.getOne(source.getId());
	}
	
	private Set<Arquivo> reverterArquivos(final Collection<ArquivoDTO> arquivos) {
		return this.arquivoDTOReverse.revert(arquivos);
	}
}