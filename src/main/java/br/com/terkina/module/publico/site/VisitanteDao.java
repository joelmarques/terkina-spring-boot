package br.com.terkina.module.publico.site;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitanteDao extends JpaRepository<Visitante, Long> {

}