package br.com.terkina.module.animal;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.terkina.base.entity.Item;
import br.com.terkina.module.arquivo.TipoArquivoEnum;
import br.com.terkina.module.localizacao.LocalizacaoDao;
import br.com.terkina.module.tipoanimal.TipoDeAnimalDao;
import br.com.terkina.module.user.UserService;

@RestController
@RequestMapping("/resources/animais")
public class AnimalController {

	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private TipoDeAnimalDao tipoDeAnimalDao;
	
	@Autowired
	private LocalizacaoDao localizacaoDao;
	
	@Autowired
	private AnimalDTOConverter converter;
	
	@Autowired
	private AnimalDTOReverse reverse;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("all")
	public Collection<IAnimal> findAll() {		
		return this.animalRepository.buscarAnimaisPorTenancia(this.userService.getCurrentTenancy());
	}
	
	@GetMapping("/{id}")
	public AnimalDTO findByID(@PathVariable("id") Long id) {		
		return this.converter.convert(this.animalRepository.getOne(id));
	}
	
	@PostMapping
	public void save(@RequestBody AnimalDTO source) {
		this.animalRepository.save(this.reverse.revert(source));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.animalRepository.deleteById(id);
	}
	
	@GetMapping("especies")
	public Collection<Item> getEspecies() {		
		return this.tipoDeAnimalDao.getItems(this.userService.getCurrentTenancy());
	}
	
	@GetMapping("localizacoes")
	public Collection<Item> getLocalizacoes() {		
		return this.localizacaoDao.getItems(this.userService.getCurrentTenancy());
	}
	
	@GetMapping("sexos")
	public SexoEnum[] getSexos() {
		return SexoEnum.values();
	}
	
	@GetMapping("situacoes")
	public SituacaoEnum[] getSituacoes() {
		return SituacaoEnum.values();
	}
	
	@GetMapping("tiposArquivos")
	public TipoArquivoEnum[] getTiposArquivos() {
		return TipoArquivoEnum.values();
	}
}