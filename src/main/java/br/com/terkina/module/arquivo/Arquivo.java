package br.com.terkina.module.arquivo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.apache.commons.lang3.StringUtils;

import br.com.terkina.base.model.EntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Arquivo extends EntityBase<Long> {

	private static final long serialVersionUID = 6469832222335449257L;
	
	@Column(name="DESCRICAO", length = 500)
	private String descricao;
	
	@Column(name="URL_ARQUIVO", length = 300, nullable = false)
	private String urlArquivo;
	
	@Enumerated(EnumType.STRING)
	private TipoArquivoEnum tipo;
	
	@Override
	public int hashCode() {
		if (this.getId() != null) {
			return this.getId().hashCode();
		}
		if (StringUtils.isNotBlank(this.getUrlArquivo())) {
			return this.getUrlArquivo().hashCode();
		}
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		return this.hasId(((Arquivo)obj).getId()) || this.hasUrl(((Arquivo)obj).getUrlArquivo());
	}
	
	private boolean hasId(final Long id) {
		if (this.getId() == null || id == null) {
            return false;
        }
        return this.getId().longValue() == id.longValue();
	}
	
	private boolean hasUrl(final String url) {
		if (StringUtils.isAnyBlank(this.getUrlArquivo(), url)) {
			return false;
		}
		return StringUtils.equalsIgnoreCase(this.getUrlArquivo(),url);
	}
	
}