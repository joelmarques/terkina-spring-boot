package br.com.terkina.module.animal;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import br.com.terkina.base.utils.DateUtils;

public interface IAnimal {
	
	public static final String DESCONHECIDO_A = "desconhecido(a)";
	
	Long getId();
	String getCodigo();
	String getNome();
	String getSexo();
	Date getDataDeNascimento();
	String getUrlFoto();
	String getProveniencia();
	String getEspecie();
	String getSituacao();
	
	default String getSexoFormatado() {
		return StringUtils.defaultIfBlank(SexoEnum.getAsLowerCase(getSexo()), DESCONHECIDO_A);
	}
	
	default String getDataDeNascimentoFormatada() {
		return StringUtils.defaultIfBlank(DateUtils.formatInFullBrazilianPattern(getDataDeNascimento()), DESCONHECIDO_A);
	}
	
	default String getIdadeFormatada() {
		return StringUtils.defaultIfBlank(DateUtils.calculateAgeInFullBrazilianPattern(getDataDeNascimento()), DESCONHECIDO_A);
	}
	
	default boolean isAniversariante() {
		return DateUtils.isBirthday(getDataDeNascimento());
	}
	
	default String getProvenienciaFormatada() {
		return StringUtils.defaultIfBlank(getProveniencia(), DESCONHECIDO_A);
	}
	
	default String getEspecieFormatada() {
		return StringUtils.defaultIfBlank(getEspecie(), DESCONHECIDO_A);
	}
	
	default String getSituacaoFormatada() {
		return StringUtils.defaultIfBlank(SituacaoEnum.getAsString(getSituacao()), DESCONHECIDO_A);
	}
}