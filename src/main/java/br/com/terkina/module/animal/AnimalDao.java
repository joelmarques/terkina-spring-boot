package br.com.terkina.module.animal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.terkina.base.model.Item;

@Repository
public interface AnimalDao extends JpaRepository<Animal, Long> {
	
	List<Animal> findByTenancy(Long tenancy);
	
	@Query(name="Animal.findAllByTenancy", nativeQuery=true)
	List<Item> findAllByTenancy(Long tenancy);
	
	@Query(name="Animal.findAllByProject", nativeQuery=true)
	List<Item> buscarAnimaisPorProjeto(Long idProjeto);
}