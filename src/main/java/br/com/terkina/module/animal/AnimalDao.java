package br.com.terkina.module.animal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.terkina.base.entity.Item;

@Repository
public interface AnimalDao extends JpaRepository<Animal, Long> {
	
	List<Animal> findByTenancy(Long tenancy);
	
	@Query(name="Animal.buscarItensPorTenancia", nativeQuery=true)
	List<Item> buscarItensPorTenancia(Long tenancy);
	
	@Query(name="Animal.buscarItensPorProjeto", nativeQuery=true)
	List<Item> buscarItensPorProjeto(Long idProjeto);
	
	@Query(name="Animal.buscarAnimaisPorTenancia", nativeQuery=true)
	List<IAnimal> buscarAnimaisPorTenancia(Long tenancy);
	
	@Query(name="Animal.buscarAnimaisPorTenanciaESituacao", nativeQuery=true)
	List<IAnimal> buscarAnimaisPorTenanciaESituacao(Long tenancy, String situacao);
	
	default public List<IAnimal> buscarAnimaisHabilitadosDaEmpresa(Long tenancy) {
		return this.buscarAnimaisPorTenanciaESituacao(tenancy, SituacaoEnum.HABILITADO.name());
	}
}