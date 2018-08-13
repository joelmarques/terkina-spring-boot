package br.com.terkina.module.ficha.clinica;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.terkina.module.animal.Animal;

@Repository
public interface FichaClinicaDao extends JpaRepository<Animal, Long>, FichaClinicaDaoCustom {

	@Query(value="select r from Biometria r where r.idAnimal = :idAnimal")
	List<Biometria> buscarBiometriasDoAnimal(@Param("idAnimal") Long idAnimal);
	
	@Query(value="select r from Manejo r where r.idAnimal = :idAnimal")
	List<Manejo> buscarManejosDoAnimal(@Param("idAnimal") Long idAnimal);
	
	@Query(value="select r from Denticao r where r.idAnimal = :idAnimal")
	List<Denticao> buscarDenticoesDoAnimal(@Param("idAnimal") Long idAnimal);

	@Query(value="select r from DadoSanitario r where r.idAnimal = :idAnimal")
	List<DadoSanitario> buscarDadosSanitariosDoAnimal(@Param("idAnimal") Long idAnimal);
	
	@Query(value="select r from HistoricoClinico r where r.idAnimal = :idAnimal")
	List<HistoricoClinico> buscarHistoricosClinicosDoAnimal(@Param("idAnimal") Long idAnimal);
	
	@Query(value="select r from Reproducao r where r.idAnimal = :idAnimal")
	List<Reproducao> buscarReproducoesDoAnimal(@Param("idAnimal") Long idAnimal);
}