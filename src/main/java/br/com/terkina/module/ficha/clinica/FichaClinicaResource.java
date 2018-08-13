package br.com.terkina.module.ficha.clinica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resources/fichasClinicas")
public class FichaClinicaResource {

	@Autowired
	private FichaClinicaDao fichaClinicaDao;
	
	@GetMapping("fichaClinica")
	public FichaClinicaDTO getFichaClinica(@RequestParam("idAnimal")Long idAnimal) {
		
		final FichaClinicaDTO fichaClinica = new FichaClinicaDTO();
		
		fichaClinica.setBiometrias(this.fichaClinicaDao.buscarBiometriasDoAnimal(idAnimal));
		fichaClinica.setManejos(this.fichaClinicaDao.buscarManejosDoAnimal(idAnimal));
		fichaClinica.setDenticoes(this.fichaClinicaDao.buscarDenticoesDoAnimal(idAnimal));
		fichaClinica.setDadosSanitarios(this.fichaClinicaDao.buscarDadosSanitariosDoAnimal(idAnimal));
		fichaClinica.setHistoricosClinicos(this.fichaClinicaDao.buscarHistoricosClinicosDoAnimal(idAnimal));
		fichaClinica.setReproducoes(this.fichaClinicaDao.buscarReproducoesDoAnimal(idAnimal));
		
		return fichaClinica;		
	}
	
	@PutMapping("salvarBiometria")
	public Biometria salvarBiometria(@RequestBody Biometria biometria) {
		return this.fichaClinicaDao.salvarBiometria(biometria);
	}
	
	@PutMapping("salvarManejo")
	public Manejo salvarBiometria(@RequestBody Manejo manejo) {
		return this.fichaClinicaDao.salvarManejo(manejo);
	}
	
	@PutMapping("salvarDenticao")
	public Denticao salvarDenticao(@RequestBody Denticao denticao) {
		return this.fichaClinicaDao.salvarDenticao(denticao);
	}
	
	@PutMapping("salvarDadoSanitario")
	public DadoSanitario salvarDadoSanitario(@RequestBody DadoSanitario dadoSanitario) {
		return this.fichaClinicaDao.salvarDadoSanitario(dadoSanitario);
	}
	
	@PutMapping("salvarHistoricoClinico")
	public HistoricoClinico salvarHistoricoClinico(@RequestBody HistoricoClinico historicoClinico) {
		return this.fichaClinicaDao.salvarHistoricoClinico(historicoClinico);
	}
	
	@PutMapping("salvarReproducao")
	public Reproducao salvarReproducao(@RequestBody Reproducao reproducao) {
		return this.fichaClinicaDao.salvarReproducao(reproducao);
	}

}