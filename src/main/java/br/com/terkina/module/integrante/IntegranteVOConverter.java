package br.com.terkina.module.integrante;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.terkina.base.converter.Converter;

@Component
public class IntegranteVOConverter implements Converter<Collection<Integrante>, Collection<IntegranteVO>> {
	
	@Autowired
	private IntegranteDTOConverter integranteDTOConverter;
	
	@Override
	public Collection<IntegranteVO> convert(Collection<Integrante> source) {
		
		return source.stream().map(this::convert).collect(Collectors.toList());
	}

	private IntegranteVO convert(Integrante integrante) {
		IntegranteVO integranteVO = new IntegranteVO();
		integranteVO.setId(integrante.getId());
		integranteVO.setNome(integrante.getNome());
		integranteVO.setEmail(integrante.getEmail());
		integranteVO.setTelefone(integrante.getTelefone());
		integranteVO.setRoles(this.integranteDTOConverter.converterRoles(integrante.getRoles()));
		integranteVO.setOrientadores(this.integranteDTOConverter.converterIntegrantes(integrante.getOrientadores()));
		integranteVO.setEnable(integrante.getEnable());
		return integranteVO;
	}
}