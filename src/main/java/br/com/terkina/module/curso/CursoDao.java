package br.com.terkina.module.curso;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoDao extends JpaRepository<Curso, Long> {
	
	List<Curso> findByTenancy(Long tenancy);
}