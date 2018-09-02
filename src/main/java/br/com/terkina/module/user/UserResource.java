package br.com.terkina.module.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resources/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("userLoggedIn")
	public User getUserLoggedIn() {
		return this.userService.getUserLoggedIn();
	}	
}