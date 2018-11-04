package br.com.terkina.module.experimento.projeto;

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
import br.com.terkina.module.animal.AnimalDao;
import br.com.terkina.module.integrante.IntegranteDao;
import br.com.terkina.module.tipopesquisa.TipoDePesquisaDao;
import br.com.terkina.module.user.UserService;

@RestController
@RequestMapping("/resources/projetosDePesquisa")
public class ProjetoPesquisaResource {
	
	@Autowired
	private ProjetoPesquisaDao projetoPesquisaDao;

	@Autowired
	private IntegranteDao integranteDao;
	
	@Autowired
	private TipoDePesquisaDao tipoDePesquisaDao;
	
	@Autowired
	private AnimalDao animalDao;
	
	@Autowired
	private ProjetoPesquisaDTOConverter converter;
	
	@Autowired
	private ProjetoPesquisaDTOReverse reverse;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("all")
	public Collection<ProjetoPesquisaVO> getProjetos() {		
		return this.projetoPesquisaDao.buscarProjetos(this.userService.getCurrentTenancy());
	}
	
	@GetMapping("/{id}")
	public ProjetoPesquisaDTO findByID(@PathVariable("id") Long id) {		
		return this.converter.convert(this.projetoPesquisaDao.getOne(id));
	}

	@PostMapping
	public void save(@RequestBody ProjetoPesquisaDTO source) {
		this.projetoPesquisaDao.save(this.reverse.revert(source));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.projetoPesquisaDao.deleteById(id);
	}
	
	@GetMapping("tiposDePesquisa")
	public Collection<Item> getTiposDePesquisa() {
		return this.tipoDePesquisaDao.buscarItensPorTenancia(this.userService.getCurrentTenancy());
	}
	
	@GetMapping("orientadores")
	public Collection<Item> getOrientadores() {
		return this.integranteDao.buscarOrientadores(this.userService.getCurrentTenancy());
	}
	
	@GetMapping("pesquisadores")
	public Collection<Item> getPesquisadores() {
		return this.integranteDao.buscarPesquisadores(this.userService.getCurrentTenancy());
	}
	
	@GetMapping("animais")
	public Collection<Item> getAnimais() {
		return this.animalDao.buscarItensPorTenancia(this.userService.getCurrentTenancy());
	}
}