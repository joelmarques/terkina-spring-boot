package br.com.terkina.module.instituicao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicaoDao extends JpaRepository<Instituicao, Long> {
	
	List<Instituicao> findByTenancy(Long tenancy);
}