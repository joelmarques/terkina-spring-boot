package br.com.terkina.module.localizacao;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.terkina.base.model.EntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString(of="nome")
@NoArgsConstructor
public class Localizacao extends EntityBase<Long> {

	private static final long serialVersionUID = -1907761100298890544L;

	@Getter @Setter
	@Column(name="NOME", length = 100, nullable = false)
	private String nome;

	@Getter @Setter
	@Column(name="SIGLA", length = 20, nullable = false)
	private String sigla;

	@Getter @Setter
	@Column(name="DESCRICAO", length = 500)
	private String descricao;

}