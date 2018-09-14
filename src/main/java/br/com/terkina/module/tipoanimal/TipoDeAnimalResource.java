package br.com.terkina.module.tipoanimal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.terkina.base.controller.SimpleRestBaseController;
import br.com.terkina.module.user.UserService;

@RestController
@RequestMapping("/resources/tiposDeAnimal")
public class TipoDeAnimalResource extends SimpleRestBaseController<TipoDeAnimal, Long, TipoDeAnimalDao> {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<TipoDeAnimal> findAll() {
		return repository.findByTenancy(this.userService.getCurrentTenancy());
	}
}