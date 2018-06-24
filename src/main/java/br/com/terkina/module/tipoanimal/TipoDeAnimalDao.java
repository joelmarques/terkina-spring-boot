package br.com.terkina.module.tipoanimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeAnimalDao extends JpaRepository<TipoDeAnimal, Long> {
	
}