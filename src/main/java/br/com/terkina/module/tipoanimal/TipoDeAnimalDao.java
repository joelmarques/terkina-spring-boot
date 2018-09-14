package br.com.terkina.module.tipoanimal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.terkina.base.model.Item;

@Repository
public interface TipoDeAnimalDao extends JpaRepository<TipoDeAnimal, Long> {
	
	List<TipoDeAnimal> findByTenancy(Long tenancy);
	
	@Query(value = "SELECT id AS id, nome AS descricao FROM tipo_animal WHERE tenancy = ?1", nativeQuery = true)
	List<Item> getItems(Long tenancy);
}