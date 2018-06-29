package br.com.terkina.module.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {

	private String name;
	private boolean admin;
	private Long tenancy;
}