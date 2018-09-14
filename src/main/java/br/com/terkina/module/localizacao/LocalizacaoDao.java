package br.com.terkina.module.localizacao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.terkina.base.model.Item;

@Repository
public interface LocalizacaoDao extends JpaRepository<Localizacao, Long> {
	
	List<Localizacao> findByTenancy(Long tenancy);
	
	@Query(value = "SELECT id AS id, nome AS descricao FROM localizacao WHERE tenancy = ?1", nativeQuery = true)
	List<Item> getItems(Long tenancy);

}