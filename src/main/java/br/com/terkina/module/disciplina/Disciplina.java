package br.com.terkina.module.disciplina;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.terkina.base.model.EntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Disciplina extends EntityBase<Long> {

	private static final long serialVersionUID = -8799122525545330960L;

	@Getter @Setter
	@Column(name="NOME", length = 100, nullable = false)
	private String nome;

	@Getter @Setter
	@Column(name="SIGLA", length = 20, nullable = false)
	private String sigla;
	
	@Getter @Setter
	@Column(name="GRAU", length = 100)
	private String grau;

	@Getter @Setter
	@Column(name="DESCRICAO", length = 500)
	private String descricao;

	@Override
	public String toString() {
		final StringBuilder descricao = new StringBuilder();
		descricao.append(this.getNome());
		descricao.append(" (");
		descricao.append(this.getSigla());
		descricao.append(")");
		return descricao.toString();
	}

}