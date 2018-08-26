package br.com.terkina.module.publico.site;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import br.com.terkina.base.utils.DateUtils;
import br.com.terkina.module.animal.SexoEnum;
import br.com.terkina.module.publico.site.ISite.IAnimal;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of="id")
public class AnimalSiteVO implements IAnimal {
	
	public static final String DESCONHECIDA = "desconhecida";
	
	private Long id;
	private String nome;
	private String codigo;
	private String sexo;
	private String urlFoto;
	private String dataDeNascimento;
	private String idade;
	private boolean aniversariante;
	private String proveniencia;

	public void setSexo(String sexo) {
		if (StringUtils.isNotBlank(sexo)) {
			this.sexo = SexoEnum.valueOf(sexo).getDescricao();
		}
	}
	
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = StringUtils.defaultIfBlank(DateUtils.formatInFullBrazilianPattern(dataDeNascimento), DESCONHECIDA);
		this.idade = StringUtils.defaultIfBlank(DateUtils.calculateAgeInFullBrazilianPattern(dataDeNascimento), DESCONHECIDA);
		this.aniversariante = DateUtils.isBirthday(dataDeNascimento);
	}
	
	public void setProveniencia(String proveniencia) {
		this.proveniencia = StringUtils.defaultIfBlank(proveniencia, DESCONHECIDA);
	}

}