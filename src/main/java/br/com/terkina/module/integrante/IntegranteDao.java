package br.com.terkina.module.integrante;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.terkina.base.enums.SituacaoEnum;
import br.com.terkina.base.model.Item;
import br.com.terkina.module.publico.site.ISite.IPessoa;
import br.com.terkina.module.user.ProfileType;

@Repository
public interface IntegranteDao extends JpaRepository<Integrante, Long> {
	
	List<Integrante> findByTenancy(Long tenancy);
	
	Integrante findByEmail(String email);
	
	@Query(name="Integrante.findTenancyByEmail", nativeQuery=true)
	Long findTenancyByEmail(String email);
	
	@Query(name="Integrante.findAllByProject", nativeQuery=true)
	List<Item> buscarPesquisadoresPorProjeto(Long idProjeto);
	
	@Query(name="Integrante.findAllByProfileAndTenancy", nativeQuery=true)
	List<Item> findAllByProfileAndTenancy(String profile, Long tenancy);
	
	@Query(name="Integrante.findAllByProfileAndTenancyAndEnable", nativeQuery=true)
	List<IPessoa> findAllByProfileAndTenancyAndEnable(String profile, Long tenancy, boolean enable);
	
	default public List<Item> buscarOrientadores(Long tenancy) {
		return this.findAllByProfileAndTenancy(ProfileType.ORIENTADOR.name(), tenancy);
	}
	
	default public List<Item> buscarPesquisadores(Long tenancy) {
		return this.findAllByProfileAndTenancy(ProfileType.PESQUISADOR.name(), tenancy);
	}

	default public List<IPessoa> buscarOrientadoresHabilitadosDaEmpresa(Long tenancy) {
		return this.findAllByProfileAndTenancyAndEnable(ProfileType.ORIENTADOR.name(), tenancy, SituacaoEnum.HABILITADO.getValor());
	}
	
	default public List<IPessoa> buscarPesquisadoresHabilitadosDaEmpresa(Long tenancy) {
		return this.findAllByProfileAndTenancyAndEnable(ProfileType.PESQUISADOR.name(), tenancy, SituacaoEnum.HABILITADO.getValor());
	}

}