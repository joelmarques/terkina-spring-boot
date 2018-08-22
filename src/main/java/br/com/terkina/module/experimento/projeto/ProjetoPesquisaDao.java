package br.com.terkina.module.experimento.projeto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.terkina.module.animal.Animal;

@Repository
public interface ProjetoPesquisaDao extends JpaRepository<ProjetoPesquisa, Long> {
	
	@Query(name="ProjetoPesquisa.findAllByTenancy", nativeQuery=true)
	List<ProjetoPesquisaVO> buscarProjetos(Long tenancy);

	@Query(name="ProjetoPesquisa.findAllByAnimal", nativeQuery=false)
	List<ProjetoPesquisa> buscarProjetosDoAnimal(@Param("animal") Animal animal);
}