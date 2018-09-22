package br.com.terkina.module.publico.site;

import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import br.com.terkina.base.utils.DateUtils;
import br.com.terkina.module.animal.SexoEnum;

public interface ISite {
	
	public static final String DESCONHECIDO_A = "desconhecido(a)";
	
	IEmpresa getEmpresa();
	Collection<IPessoa> getOrientadores();	
	Collection<IPessoa> getPesquisadores();	
	Collection<IAnimal> getAnimais();
	
	public interface IEmpresa {
		Long getTenancy();
		String getResumo();
		String getEmail();
		String getObjetivoUm();
		String getObjetivoDois();
		String getObjetivoTres();
		String getUrlVideo();
	}
	
	public interface IPessoa {		
		String getNome();
		String getResumo();
		String getCurriculoLattes();
		String getEmail();
		String getFacebook();
		String getUrlFoto();
	}
	
	public interface IAnimal {
		Long getId();
		String getNome();
		String getCodigo();
		String getSexagem();
		String getUrlFoto();
		Date getNascimento();
		String getOrigem();
		
		default String getSexo() {
			return StringUtils.defaultIfBlank(SexoEnum.getAsString(getSexagem()), DESCONHECIDO_A);
		}
		
		default String getDataDeNascimento() {
			return StringUtils.defaultIfBlank(DateUtils.formatInFullBrazilianPattern(getNascimento()), DESCONHECIDO_A);
		}
		
		default String getIdade() {
			return StringUtils.defaultIfBlank(DateUtils.calculateAgeInFullBrazilianPattern(getNascimento()), DESCONHECIDO_A);
		}
		
		default boolean isAniversariante() {
			return DateUtils.isBirthday(getNascimento());
		}
		
		default String getProveniencia() {
			return StringUtils.defaultIfBlank(getOrigem(), DESCONHECIDO_A);
		}
	}

}