package br.com.terkina.module.user;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.terkina.base.utils.Mensagem;
import br.com.terkina.base.utils.PasswordUtils;
import br.com.terkina.module.integrante.Integrante;
import br.com.terkina.module.integrante.IntegranteDao;

@Service("userService")
public class DefaultUserService implements UserService {
	
	@Autowired
	private IntegranteDao integranteDao;

	@Override
	public Long getCurrentTenancy() {
		return this.getTenancy(getAuthentication());
	}
	
	@Override
	public User getUserLoggedIn() {
		final Authentication authentication = this.getAuthentication();
		return new User(this.getName(authentication), this.isAdmin(authentication), this.getTenancy(authentication));
	}
	
	private Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	private String getName(final Authentication authentication) {
		return authentication.getName();
	}
	
	private boolean isAdmin(final Authentication authentication) {
		return authentication.getAuthorities().stream().anyMatch(p -> p.getAuthority().contains(ProfileType.ADMIN.name()));
	}
	
	private Long getTenancy(final Authentication authentication) {
		return this.integranteDao.findTenancyByEmail(authentication.getName());
	}

	@Override
	public boolean createUpdateAccount(final String email) {
		
		if (StringUtils.isNotBlank(email)) {
			
			Integrante integrante = this.integranteDao.findByEmail(email);
			
			if (Objects.isNull(integrante)) {
				integrante = this.createNewAccount(email);
				integrante.setTenancy(this.getNextTenancy());
			}
			
			String password = PasswordUtils.getRandomPassword();			
			integrante.setPassword(PasswordUtils.encode(password));			
			this.integranteDao.save(integrante);
			
			Mensagem.criar(email, password).enviar();
			return true;
		}
		
		return false;
	}
	
	private Long getNextTenancy() {
		return Optional.ofNullable(this.integranteDao.findMaxTenancy()).orElse(new Long(1));
	}
	
	private Integrante createNewAccount(final String email) {
		
		final Integrante integrante = new Integrante();
		integrante.setNome(email);
		integrante.setEmail(email);
		integrante.setEnable(Boolean.TRUE);
		integrante.setRoles(new HashSet<Profile>(Arrays.asList(Profile.admin())));
		return integrante;
	}

}