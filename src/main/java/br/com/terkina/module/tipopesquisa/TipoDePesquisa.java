package br.com.terkina.module.tipopesquisa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.terkina.base.model.EntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="TIPO_PESQUISA")
@ToString(of="nome")
@NoArgsConstructor
public class TipoDePesquisa extends EntityBase<Long> {

	private static final long serialVersionUID = -8176892630074913302L;

	@Getter @Setter
	@Column(name="NOME", length = 100, nullable = false)
	private String nome;

	@Getter @Setter
	@Column(name="DESCRICAO", length = 500)
	private String descricao;
}