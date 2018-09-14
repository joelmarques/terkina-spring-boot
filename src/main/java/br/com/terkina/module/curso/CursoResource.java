package br.com.terkina.module.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.terkina.base.controller.SimpleRestBaseController;
import br.com.terkina.module.user.UserService;

@RestController
@RequestMapping("/resources/cursos")
public class CursoResource extends SimpleRestBaseController<Curso, Long, CursoDao> {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<Curso> findAll() {
		return repository.findByTenancy(this.userService.getCurrentTenancy());
	}
	
}