package br.com.terkina.module.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class User {

	private String name;
	private boolean admin;
	private Long tenancy;
}