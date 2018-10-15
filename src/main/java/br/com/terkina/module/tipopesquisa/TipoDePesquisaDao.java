package br.com.terkina.module.tipopesquisa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.terkina.base.entity.Item;

@Repository
public interface TipoDePesquisaDao extends JpaRepository<TipoDePesquisa, Long> {
	
	List<TipoDePesquisa> findByTenancy(Long tenancy);
	
	@Query(name="TipoDePesquisa.findAllByTenancy", nativeQuery=true)
	List<Item> findAllByTenancy(Long tenancy);
}