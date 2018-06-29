package br.com.terkina.module.user;

import org.springframework.stereotype.Service;

@Service("userService")
public class DefaultUserService implements UserService {

	@Override
	public Long getCurrentTenancy() {
		// TODO Auto-generated method stub
		return Long.valueOf(1);
	}

}