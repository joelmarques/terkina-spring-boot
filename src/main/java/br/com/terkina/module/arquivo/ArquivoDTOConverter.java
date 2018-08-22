package br.com.terkina.module.arquivo;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.terkina.base.converter.Converter;

@Component
public class ArquivoDTOConverter implements Converter<Collection<Arquivo>, Collection<ArquivoDTO>> {

	@Override
	public Collection<ArquivoDTO> convert(Collection<Arquivo> source) {
		return source.stream().map(ArquivoDTO::new).collect(Collectors.toList());
	}	
}