package br.com.terkina.module.ficha.clinica;

public interface FichaClinicaDaoCustom {
	Biometria salvarBiometria(Biometria biometria);
	Manejo salvarManejo(Manejo manejo);
	Denticao salvarDenticao(Denticao denticao);
	DadoSanitario salvarDadoSanitario(DadoSanitario dadoSanitario);
	HistoricoClinico salvarHistoricoClinico(HistoricoClinico historicoClinico);
	Reproducao salvarReproducao(Reproducao reproducao);
}