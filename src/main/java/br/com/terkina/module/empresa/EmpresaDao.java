package br.com.terkina.module.empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaDao extends JpaRepository<Empresa, Long> {
	
	Empresa findByTenancy(Long tenancy);
}