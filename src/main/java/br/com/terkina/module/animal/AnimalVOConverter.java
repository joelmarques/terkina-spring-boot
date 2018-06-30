package br.com.terkina.module.animal;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.terkina.base.converter.Converter;
import br.com.terkina.base.utils.DateUtils;

@Component
public class AnimalVOConverter implements Converter<Collection<Animal>, Collection<AnimalVO>> {
	
	private static final String DESCONHECIDA = "desconhecida";
	
	@Override
	public Collection<AnimalVO> convert(Collection<Animal> source) {
		
		return source.stream().map(this::convert).collect(Collectors.toList());
	}
	
	private AnimalVO convert(Animal animal) {
		AnimalVO animalVO = new AnimalVO();
		animalVO.setId(animal.getId());
		animalVO.setNome(animal.getNome());
		animalVO.setCodigo(animal.getCodigo());
		animalVO.setSexo(Objects.nonNull(animal.getSexo()) ? animal.getSexo().getDescricao() : null);
		animalVO.setEspecie(Objects.nonNull(animal.getTipoDeAnimal()) ? animal.getTipoDeAnimal().getNome() : null);
		animalVO.setProveniencia(Objects.nonNull(animal.getOrigem()) ? animal.getOrigem().getSigla() : DESCONHECIDA);
		animalVO.setDataDeNascimento(DateUtils.format(animal.getDataDeNascimento()));
		animalVO.setSituacao(Objects.nonNull(animal.getSituacao()) ? animal.getSituacao().getDescricao() : null);
		animalVO.setUrlFoto(animal.getUrlFoto());
		return animalVO;
	}

}