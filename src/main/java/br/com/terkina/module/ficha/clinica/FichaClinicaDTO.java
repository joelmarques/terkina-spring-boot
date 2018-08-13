package br.com.terkina.module.ficha.clinica;

import java.util.Collection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class FichaClinicaDTO {
	
	private Collection<Biometria> biometrias;
	private Collection<Manejo> manejos;
	private Collection<Denticao> denticoes;
	private Collection<DadoSanitario> dadosSanitarios;
	private Collection<HistoricoClinico> historicosClinicos;
	private Collection<Reproducao> reproducoes;
}