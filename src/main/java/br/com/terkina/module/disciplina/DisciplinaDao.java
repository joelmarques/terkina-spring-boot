package br.com.terkina.module.disciplina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaDao extends JpaRepository<Disciplina, Long> {

}