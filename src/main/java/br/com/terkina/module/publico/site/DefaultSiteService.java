package br.com.terkina.module.publico.site;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.terkina.module.animal.Animal;
import br.com.terkina.module.animal.AnimalDao;
import br.com.terkina.module.empresa.EmpresaDao;
import br.com.terkina.module.experimento.projeto.ProjetoPesquisa;
import br.com.terkina.module.experimento.projeto.ProjetoPesquisaDao;
import br.com.terkina.module.historico.escolar.HistoricoEscolar;
import br.com.terkina.module.historico.escolar.IHistoricoEscolar;
import br.com.terkina.module.integrante.IntegranteDao;
import br.com.terkina.module.publico.site.ISite.IAnimal;
import br.com.terkina.module.publico.site.ISite.IEmpresa;
import br.com.terkina.module.publico.site.ISite.IPessoa;

@Service("siteService")
public class DefaultSiteService implements SiteService {
	
	@Autowired
	private EmpresaDao empresaDao;
	
	@Autowired
	private IntegranteDao integranteDao;
	
	@Autowired
	private AnimalDao animalDao;
	
	@Autowired
	private ProjetoPesquisaDao projetoPesquisaDao;
	
	@Autowired
	private VisitanteDao visitanteDao;
	
	@Override
	public ISite buscarSite(String identificadorDoSite) {
		
		IEmpresa empresa = this.buscarEmpresaPorIdentificadorDoSite(identificadorDoSite);
		Collection<IPessoa> orientadores = this.buscarOrientadoresHabilitadosDaEmpresa(empresa.getTenancy());
		Collection<IPessoa> pesquisadores = this.buscarPesquisadoresHabilitadosDaEmpresa(empresa.getTenancy());
		Collection<IAnimal> animais = this.buscarAnimaisHabilitadosDaEmpresa(empresa.getTenancy());
		
		pesquisadores.removeAll(orientadores);
		
		return new Site(empresa, orientadores, pesquisadores, animais);
	}
	
	private IEmpresa buscarEmpresaPorIdentificadorDoSite(String identificadorDoSite) {
		return this.empresaDao.buscarEmpresaPorIdentificadorDoSite(identificadorDoSite);
	}

	private Collection<IPessoa> buscarOrientadoresHabilitadosDaEmpresa(Long tenancy) {
		return this.integranteDao.buscarOrientadoresHabilitadosDaEmpresa(tenancy);
	}

	private Collection<IPessoa> buscarPesquisadoresHabilitadosDaEmpresa(Long tenancy) {
		return this.integranteDao.buscarPesquisadoresHabilitadosDaEmpresa(tenancy);
	}

	private Collection<IAnimal> buscarAnimaisHabilitadosDaEmpresa(Long tenancy) {
		return this.animalDao.buscarAnimaisHabilitadosDaEmpresa(tenancy);
	}
	
	@Override
	public IHistoricoEscolar buscarHistoricoEscolar(Long idAnimal) {
		final Animal animal = this.animalDao.getOne(idAnimal);
		final Collection<ProjetoPesquisa> projetos = this.projetoPesquisaDao.buscarProjetosDoAnimal(animal);
		return new HistoricoEscolar(animal, projetos);
	}
	
	@Override
	public void salvarVisitante(Visitante visitante) {
		this.visitanteDao.save(visitante.cadastradoHoje());
	}

}