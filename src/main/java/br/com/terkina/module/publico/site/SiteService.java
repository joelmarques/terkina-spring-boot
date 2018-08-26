package br.com.terkina.module.publico.site;

import br.com.terkina.module.historico.escolar.IHistoricoEscolar;

public interface SiteService {
	
	ISite buscarSite(String identificadorDoSite);
	IHistoricoEscolar buscarHistoricoEscolar(Long idAnimal);
	void salvarVisitante(Visitante visitante);
}