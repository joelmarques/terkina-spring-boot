package br.com.terkina.base.context;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

public class DefaultAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());
	}
}