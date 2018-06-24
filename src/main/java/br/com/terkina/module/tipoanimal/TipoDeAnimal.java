package br.com.terkina.module.tipoanimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.terkina.base.model.EntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="TIPO_ANIMAL")
@ToString(of="nome")
@NoArgsConstructor
public class TipoDeAnimal extends EntityBase<Long> {
	
	private static final long serialVersionUID = -1030657083067445027L;
	
	@Getter @Setter
	@Column(name="NOME", length = 100, nullable = false)
	private String nome;
	
	@Getter @Setter
	@Column(name="NOME_VULGAR", length = 100)
	private String nomeVulgar;
	
	@Getter @Setter
	@Column(name="DESCRICAO", length = 500)
	private String descricao;
	
}