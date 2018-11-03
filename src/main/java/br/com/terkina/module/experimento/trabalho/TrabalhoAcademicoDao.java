package br.com.terkina.module.experimento.trabalho;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository 
public interface TrabalhoAcademicoDao extends JpaRepository<TrabalhoAcademico, Long> {
	
	@Query(name="TrabalhoAcademico.buscarTrabalhosAcademicosPorProjeto", nativeQuery=true)
	List<TrabalhoAcademicoVO> buscarTrabalhosAcademicosPorProjeto(Long idProjeto);
}