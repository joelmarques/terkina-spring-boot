package br.com.terkina.module.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoDao extends JpaRepository<Curso, Long> {

}