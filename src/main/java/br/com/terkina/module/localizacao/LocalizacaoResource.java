package br.com.terkina.module.localizacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.terkina.base.controller.SimpleRestBaseController;
import br.com.terkina.module.user.UserService;

@RestController
@RequestMapping("/resources/localizacoes")
public class LocalizacaoResource extends SimpleRestBaseController<Localizacao, Long, LocalizacaoDao> {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<Localizacao> findAll() {
		return repository.findByTenancy(this.userService.getCurrentTenancy());
	}

}