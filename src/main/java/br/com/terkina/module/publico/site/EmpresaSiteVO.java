package br.com.terkina.module.publico.site;

import br.com.terkina.module.publico.site.ISite.IEmpresa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class EmpresaSiteVO implements IEmpresa {
	
	private Long tenancy;
	private String resumo;
	private String email;
	private String objetivoUm;
	private String objetivoDois;
	private String objetivoTres;
	private String urlVideo;
}