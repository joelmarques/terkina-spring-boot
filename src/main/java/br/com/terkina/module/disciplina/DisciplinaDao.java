package br.com.terkina.module.disciplina;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.terkina.base.entity.Item;

@Repository
public interface DisciplinaDao extends JpaRepository<Disciplina, Long> {
	
	List<Disciplina> findByTenancy(Long tenancy);
	
	@Query(name="Disciplina.findAllByTenancy", nativeQuery=true)
	List<Item> findAllByTenancy(Long tenancy);
}