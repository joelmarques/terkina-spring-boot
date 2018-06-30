package br.com.terkina.module.animal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalDao extends JpaRepository<Animal, Long> {
	
	List<Animal> findByTenancy(Long tenancy);
}