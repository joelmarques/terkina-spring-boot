package br.com.terkina.module.animal;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.terkina.base.converter.Converter;
import br.com.terkina.base.model.ItemVO;
import br.com.terkina.base.utils.DateUtils;
import br.com.terkina.module.arquivo.Arquivo;
import br.com.terkina.module.arquivo.ArquivoDTO;
import br.com.terkina.module.arquivo.ArquivoDTOConverter;
import br.com.terkina.module.localizacao.Localizacao;
import br.com.terkina.module.tipoanimal.TipoDeAnimal;

@Component
public class AnimalDTOConverter implements Converter<Animal, AnimalDTO> {
	
	@Autowired
	private ArquivoDTOConverter arquivoDTOConverter;
	
	@Override
	public AnimalDTO convert(final Animal source) {
		
		final AnimalDTO target = new AnimalDTO();
		target.setId(source.getId());
		target.setNome(source.getNome());
		target.setCodigo(source.getCodigo());
		target.setDataDeNascimento(DateUtils.format(source.getDataDeNascimento()));
		target.setEspecie(this.converterEspecie(source.getTipoDeAnimal()));
		target.setSexo(source.getSexo());
		target.setSituacao(source.getSituacao());
		target.setOrigem(this.converterOrigem(source.getOrigem()));
		target.setDataDeEntrada(DateUtils.format(source.getDataDeEntrada()));
		target.setDestino(this.converterDestino(source.getDestino()));
		target.setDataDeSaida(DateUtils.format(source.getDataDeSaida()));
		target.setCausaDaSaida(source.getCausaDaSaida());
		target.setDescricao(source.getDescricao());
		target.setUrlFoto(source.getUrlFoto());
		target.setArquivos(this.converterArquivos(source.getArquivos()));
		
		return target;
	}
	
	private ItemVO converterEspecie(final TipoDeAnimal source) {
		return source == null ? null : new ItemVO(source.getId(), source.getNome());
	}
	
	private ItemVO converterOrigem(Localizacao source) {
		return source == null ? null : new ItemVO(source.getId(), source.getNome());
	}
	
	private ItemVO converterDestino(Localizacao source) {
		return source == null ? null : new ItemVO(source.getId(), source.getNome());
	}
	
	private Collection<ArquivoDTO> converterArquivos(final Set<Arquivo> arquivos) {
		return this.arquivoDTOConverter.convert(arquivos);
	}
}