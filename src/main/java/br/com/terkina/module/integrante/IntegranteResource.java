package br.com.terkina.module.integrante;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.terkina.base.model.Item;
import br.com.terkina.base.utils.Mensagem;
import br.com.terkina.module.curso.CursoDao;
import br.com.terkina.module.user.ProfileDao;
import br.com.terkina.module.user.UserService;

@RestController
@RequestMapping("/resources/integrantes")
public class IntegranteResource {
	
	@Autowired
	private IntegranteDao integranteDao;
	
	@Autowired
	private CursoDao cursoDao;
	
	@Autowired
	private ProfileDao profileDao;
	
	@Autowired
	private IntegranteDTOConverter converter;
	
	@Autowired
	private IntegranteDTOReverse reverse;
	
	@Autowired
	private IntegranteVOConverter integranteVOConverter;
	
	@Autowired
	private UserService userService;

	@GetMapping
	public Collection<IntegranteVO> findAll() {
		return this.integranteVOConverter.convert(this.integranteDao.findByTenancy(this.userService.getCurrentTenancy()));
	}
	
	@GetMapping("/{id}")
	public IntegranteDTO findByID(@PathVariable("id") Long id) {		
		return this.converter.convert(this.integranteDao.getOne(id));
	}
	
	@PostMapping
	public void save(IntegranteDTO source) {
		this.integranteDao.save(this.reverse.revert(source));
		this.enviarEmailDoLogin(source);
	}
	
	private void enviarEmailDoLogin(final IntegranteDTO integranteDTO) {
		
		if (StringUtils.isNoneBlank(integranteDTO.getEmail(), integranteDTO.getPassword())) {
			Mensagem.criar(integranteDTO.getNome(), integranteDTO.getEmail(), integranteDTO.getEmail(), integranteDTO.getPassword())
					.enviar();
		}
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.integranteDao.deleteById(id);
	}
	
	@GetMapping("roles")
	public Collection<Item> getRoles() {
		return this.converter.converterRoles(this.profileDao.findAll());
	}
	
	@GetMapping("cursos")
	public Collection<Item> getCursos() {
		return this.converter.converterCursos(this.cursoDao.findByTenancy(this.userService.getCurrentTenancy()));
	}
	
	@GetMapping("orientadores")
	public Collection<Item> getOrientadores() {
		return this.integranteDao.buscarOrientadores(this.userService.getCurrentTenancy());
	}
}