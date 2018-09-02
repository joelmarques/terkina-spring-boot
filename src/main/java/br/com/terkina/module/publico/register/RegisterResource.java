package br.com.terkina.module.publico.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.terkina.module.user.UserService;

@RestController
@RequestMapping("/publico/register")
public class RegisterResource {
	
	@Autowired
	private UserService userService;

	@PostMapping
	public boolean createAccount(String email) {
		
		return this.userService.createUpdateAccount(email);
	}
}