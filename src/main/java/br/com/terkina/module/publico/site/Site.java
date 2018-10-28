package br.com.terkina.module.publico.site;

import java.util.Collection;

import br.com.terkina.module.animal.IAnimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Site implements ISite {
	
	private IEmpresa empresa;	
	private Collection<IPessoa> orientadores;	
	private Collection<IPessoa> pesquisadores;	
	private Collection<IAnimal> animais;
}