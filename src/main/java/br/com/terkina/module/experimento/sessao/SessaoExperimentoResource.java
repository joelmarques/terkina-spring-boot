package br.com.terkina.module.experimento.sessao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.terkina.base.entity.Item;
import br.com.terkina.module.animal.AnimalDao;
import br.com.terkina.module.arquivo.TipoArquivoEnum;
import br.com.terkina.module.disciplina.DisciplinaDao;
import br.com.terkina.module.integrante.IntegranteDao;
import br.com.terkina.module.user.UserService;

@RestController
@RequestMapping("/resources/sessoesDeExperimento")
public class SessaoExperimentoResource {
	
	@Autowired
	private SessaoExperimentoDao sessaoExperimentoDao;
	
	@Autowired
	private IntegranteDao integranteDao;
	
	@Autowired
	private AnimalDao animalDao;
	
	@Autowired
	private DisciplinaDao disciplinaDao;
	
	@Autowired
	private SessaoExperimentoDTOConverter converter;
	
	@Autowired
	private SessaoExperimentoDTOReverse reverse;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("sessoes")
	public Collection<SessaoExperimentoVO> getSessoesPorProjeto(@RequestParam("idProjeto") Long idProjeto) {
		return this.sessaoExperimentoDao.buscarSessoesPorProjeto(idProjeto);
	}
	
	@GetMapping("/{id}")
	public SessaoExperimentoDTO findByID(@PathVariable("id") Long id) {		
		return this.converter.convert(this.sessaoExperimentoDao.getOne(id));
	}
	
	@PostMapping
	public void save(@RequestBody SessaoExperimentoDTO source) {
		this.sessaoExperimentoDao.save(this.reverse.revert(source));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.sessaoExperimentoDao.deleteById(id);
	}
	
	@GetMapping("disciplinas")
	public Collection<Item> getDisciplinas() {
		return this.disciplinaDao.findAllByTenancy(this.userService.getCurrentTenancy());
	}
	
	@GetMapping("pesquisadores")
	public Collection<Item> getPesquisadores(@RequestParam("idProjeto") Long idProjeto) {
		return this.integranteDao.buscarPesquisadoresPorProjeto(idProjeto);
	}
	
	@GetMapping("animais")
	public Collection<Item> getAnimais(@RequestParam("idProjeto") Long idProjeto) {
		return this.animalDao.buscarAnimaisPorProjeto(idProjeto);
	}
	
	@GetMapping("tiposArquivos")
	public TipoArquivoEnum[] getTiposArquivos() {
		return TipoArquivoEnum.values();
	}

}