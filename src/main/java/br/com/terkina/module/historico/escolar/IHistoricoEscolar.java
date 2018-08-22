package br.com.terkina.module.historico.escolar;

import java.util.Collection;

public interface IHistoricoEscolar {
	String getNome();
	String getUrlFoto();
	String getIdade();
	String getSexo();
	String getNascimento();
	String getCodigo();
	String getEspecie();
	String getProveniencia();
	Collection<IProjeto> getProjetos();
	Collection<String> getVideos();
	Collection<String> getImagens();
	
	public interface IProjeto {
		String getInicio();
		String getFim();
		String getTitulo();
		String getResumo();
		Collection<String> getIntegrantes();
		Collection<String> getDisciplinasCursadas();
		Collection<ITrabalho> getTrabalhosPublicados();
	}
	
	public interface ITrabalho {
		String getTitulo();
		String getUrlArquivo();
	}
}