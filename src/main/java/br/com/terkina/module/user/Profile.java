package br.com.terkina.module.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Profile {
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="NAME")
	private ProfileType name;
	
	public static Profile admin() {
		Profile role  = new Profile();
		role.setId(Long.valueOf(ProfileType.ADMIN.ordinal() + 1));
		role.setName(ProfileType.ADMIN);
		return role;
	}
}