package br.com.terkina.module.instituicao;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.terkina.base.entity.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Instituicao extends AbstractEntity<Long> {

	private static final long serialVersionUID = 2175678654852054488L;

	@Getter @Setter
	@Column(name="NOME", length = 100, nullable = false)
	private String nome;

	@Getter @Setter
	@Column(name="SIGLA", length = 20, nullable = false)
	private String sigla;
	
	@Override
	public String toString() {
		return this.getNome();
	}
}