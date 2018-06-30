package br.com.terkina.module.arquivo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArquivoDao extends JpaRepository<Arquivo, Long> {

}