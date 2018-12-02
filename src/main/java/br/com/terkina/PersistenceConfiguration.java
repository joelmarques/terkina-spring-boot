package br.com.terkina;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.terkina.base.auditor.DefaultAuditorAware;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class PersistenceConfiguration {
	
	@Bean
	public AuditorAware<String> auditorAware() {
		
		return new DefaultAuditorAware();
	}

}