package br.com.terkina.module.tipopesquisa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.terkina.base.entity.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TIPO_PESQUISA")
@NoArgsConstructor
@Getter @Setter
public class TipoDePesquisa extends AbstractEntity<Long> {

	private static final long serialVersionUID = -8176892630074913302L;

	@Column(name="NOME", length = 100, nullable = false)
	private String nome;

	@Column(name="DESCRICAO", length = 500)
	private String descricao;
	
	@Override
	public String toString() {
		return this.getNome();
	}
}