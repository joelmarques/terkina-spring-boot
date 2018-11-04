package br.com.terkina.module.disciplina;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.terkina.base.entity.Item;

@Repository
public interface DisciplinaDao extends JpaRepository<Disciplina, Long> {
	
	List<Disciplina> findByTenancy(Long tenancy);
	
	@Query(value = "SELECT id AS id, nome AS descricao FROM disciplina WHERE tenancy = ?1", nativeQuery = true)
	List<Item> buscarItensPorTenancia(Long tenancy);
}