package br.com.terkina.base.entity;

import java.util.Objects;

import javax.persistence.PrePersist;

import br.com.terkina.base.context.ApplicationContextWrapper;
import br.com.terkina.module.user.UserService;

public class AbstractEntityListener {

	@PrePersist
	public void prePersist(AbstractEntity abstractEntity) {
		if (Objects.isNull(abstractEntity.getTenancy())) {
			abstractEntity.setTenancy(this.getUserService().getCurrentTenancy());			
		}
	}
	
	private UserService getUserService() {
		return ApplicationContextWrapper.getApplicationContext().getBean(UserService.class);
	}

}