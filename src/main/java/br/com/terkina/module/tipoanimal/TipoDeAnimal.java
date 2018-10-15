package br.com.terkina.module.tipoanimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.terkina.base.entity.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TIPO_ANIMAL")
@NoArgsConstructor
@Getter @Setter
public class TipoDeAnimal extends AbstractEntity<Long> {
	
	private static final long serialVersionUID = -1030657083067445027L;
	
	@Column(name="NOME", length = 100, nullable = false)
	private String nome;
	
	@Column(name="NOME_VULGAR", length = 100)
	private String nomeVulgar;
	
	@Column(name="DESCRICAO", length = 500)
	private String descricao;
	
	@Override
	public String toString() {
		return this.getNome();
	}
}