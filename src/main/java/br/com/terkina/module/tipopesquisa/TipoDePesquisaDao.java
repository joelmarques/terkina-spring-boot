package br.com.terkina.module.tipopesquisa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDePesquisaDao extends JpaRepository<TipoDePesquisa, Long> {
	
}