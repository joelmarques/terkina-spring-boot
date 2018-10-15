package br.com.terkina.module.integrante;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.terkina.base.converter.Converter;
import br.com.terkina.base.entity.Item;
import br.com.terkina.module.curso.Curso;
import br.com.terkina.module.user.Profile;

@Component
public class IntegranteDTOConverter implements Converter<Integrante, IntegranteDTO> {

	@Override
	public IntegranteDTO convert(Integrante source) {
		
		IntegranteDTO target = new IntegranteDTO();
		
		target.setId(source.getId());
		target.setTenancy(source.getTenancy());
		target.setNome(source.getNome());
		target.setCpf(source.getCpf());
		target.setEmail(source.getEmail());
		target.setTelefone(source.getTelefone());
		target.setLinkedin(source.getLinkedin());
		target.setFacebook(source.getFacebook());
		target.setCurriculoLattes(source.getCurriculoLattes());
		target.setResumo(source.getResumo());
		target.setUrlFoto(source.getUrlFoto());
		target.setEnable(source.getEnable());
		target.setRoles(this.converterRoles(source.getRoles()));
		target.setOrientadores(this.converterIntegrantes(source.getOrientadores()));
		target.setCursos(this.converterCursos(source.getCursos()));
		
		return target;
	}
	
	public List<Item> converterRoles(final Collection<Profile> itens) {
		return itens.stream().map(this::converter).collect(Collectors.toList());
	}
	
	private Item converter(Profile item) {
		return Item.create(item.getId(), item.getName().getDescricao());
	}
	
	public List<Item> converterIntegrantes(final Collection<Integrante> itens) {
		return itens.stream().map(this::converter).collect(Collectors.toList());
	}
	
	private Item converter(Integrante item) {
		return Item.create(item.getId(), item.getNome());
	}
	
	public List<Item> converterCursos(final Collection<Curso> itens) {
		return itens.stream().map(this::converter).collect(Collectors.toList());
	}
	
	private Item converter(Curso item) {
		return Item.create(item.getId(), item.nomeDoCursoMaisSiglaDaInstituicao());
	}
	
}