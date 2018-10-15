package br.com.terkina.module.curso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.StringUtils;

import br.com.terkina.base.entity.AbstractEntity;
import br.com.terkina.module.instituicao.Instituicao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString(of="nome")
@NoArgsConstructor
@Getter @Setter
public class Curso extends AbstractEntity<Long> {
	
	private static final long serialVersionUID = -6605341158982266054L;

	@Column(name="NOME", length = 100, nullable = false)
	private String nome;

	@Column(name="SIGLA", length = 20, nullable = false)
	private String sigla;

	@ManyToOne(optional = false)
	@JoinColumn(name="ID_INSTITUICAO", nullable = false)
	private Instituicao instituicao;
	
	public String nomeDoCursoMaisSiglaDaInstituicao() {
		
		StringBuilder descricao = new StringBuilder();
		descricao.append(this.getNome());
		
		if (this.getInstituicao() != null && StringUtils.isNotBlank(this.getInstituicao().getSigla())) {
			descricao.append("/"+this.getInstituicao().getSigla());
		}
		
		return descricao.toString();		
	}
}