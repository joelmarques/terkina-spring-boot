package br.com.terkina.module.curso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.terkina.base.model.EntityBase;
import br.com.terkina.module.instituicao.Instituicao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString(of="nome")
@NoArgsConstructor
public class Curso extends EntityBase<Long> {
	
	private static final long serialVersionUID = -6605341158982266054L;

	@Getter @Setter
	@Column(name="NOME", length = 100, nullable = false)
	private String nome;

	@Getter @Setter
	@Column(name="SIGLA", length = 20, nullable = false)
	private String sigla;

	@Getter @Setter
	@ManyToOne(optional = false)
	@JoinColumn(name="ID_INSTITUICAO", nullable = false)
	private Instituicao instituicao;
}