package br.com.terkina.module.instituicao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicaoDao extends JpaRepository<Instituicao, Long> {

}