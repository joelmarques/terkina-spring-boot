package br.com.terkina.module.animal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.terkina.base.entity.Item;
import br.com.terkina.module.publico.site.ISite.IAnimal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
	
	List<Animal> findByTenancy(Long tenancy);
	
	@Query(name="Animal.findAllByTenancy", nativeQuery=true)
	List<Item> findAllByTenancy(Long tenancy);
	
	@Query(name="Animal.findAllByProject", nativeQuery=true)
	List<Item> findAllByProject(Long projectId);
	
	@Query(name="Animal.findAllByTenancyAndEnabled", nativeQuery=true)
	List<IAnimal> findAllByTenancyAndEnabled(Long tenancy, String situacao);
	
	default public List<IAnimal> buscarAnimaisHabilitadosDaEmpresa(Long tenancy) {
		return this.findAllByTenancyAndEnabled(tenancy, SituacaoEnum.HABILITADO.name());
	}
}