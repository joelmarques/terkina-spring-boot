package br.com.terkina.module.experimento.sessao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoExperimentoDao extends JpaRepository<SessaoExperimento, Long> {
	
	@Query(name="SessaoExperimento.findAllByProject", nativeQuery=true)
	List<SessaoExperimentoVO> buscarSessoesPorProjeto(Long idProjeto);
}