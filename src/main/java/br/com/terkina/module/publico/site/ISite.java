package br.com.terkina.module.publico.site;

import java.util.Collection;

import br.com.terkina.module.animal.IAnimal;

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
	
	

}