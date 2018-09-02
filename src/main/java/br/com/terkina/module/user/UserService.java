package br.com.terkina.module.user;

public interface UserService {
	
	User getUserLoggedIn();
	Long getCurrentTenancy();
	boolean createUpdateAccount(String email);
}