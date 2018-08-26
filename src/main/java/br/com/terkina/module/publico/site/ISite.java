package br.com.terkina.module.publico.site;

import java.util.Collection;

public interface ISite {
	
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
		String getSexo();
		String getUrlFoto();
		String getDataDeNascimento();
		String getIdade();
		boolean isAniversariante();
		String getProveniencia();
	}

}