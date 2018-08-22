package br.com.terkina.module.experimento.sessao;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class SessaoExperimentoVO {
	private Long id;
	private String disciplina;
	private Date dataSessao;
}