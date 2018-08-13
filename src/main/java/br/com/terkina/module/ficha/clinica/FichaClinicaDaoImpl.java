package br.com.terkina.module.ficha.clinica;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public class FichaClinicaDaoImpl implements FichaClinicaDaoCustom {
	
	@PersistenceContext
    private EntityManager em;

	@Override
	@Transactional
	public Biometria salvarBiometria(Biometria biometria) {
		return em.merge(biometria);
	}

	@Override
	@Transactional
	public Manejo salvarManejo(Manejo manejo) {
		return em.merge(manejo);
	}

	@Override
	@Transactional
	public Denticao salvarDenticao(Denticao denticao) {
		return em.merge(denticao);
	}

	@Override
	@Transactional
	public DadoSanitario salvarDadoSanitario(DadoSanitario dadoSanitario) {
		return em.merge(dadoSanitario);
	}

	@Override
	@Transactional
	public HistoricoClinico salvarHistoricoClinico(HistoricoClinico historicoClinico) {
		return em.merge(historicoClinico);
	}

	@Override
	@Transactional
	public Reproducao salvarReproducao(Reproducao reproducao) {
		return em.merge(reproducao);
	}

}
