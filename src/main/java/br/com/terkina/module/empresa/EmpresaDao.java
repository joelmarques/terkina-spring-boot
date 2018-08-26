package br.com.terkina.module.empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.terkina.module.publico.site.ISite.IEmpresa;

@Repository
public interface EmpresaDao extends JpaRepository<Empresa, Long> {
	
	Empresa findByTenancy(Long tenancy);
	
	@Query(name="Empresa.findOneByIdentifier", nativeQuery=true)
	IEmpresa buscarEmpresaPorIdentificadorDoSite(String identificadorDoSite);
}