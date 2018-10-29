package br.com.terkina.module.arquivo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.terkina.base.converter.Reverse;

@Component
public class ArquivoDTOReverse implements Reverse<Collection<ArquivoDTO>, Set<Arquivo>> {
	
	@Autowired
	private ArquivoDao arquivoDao;
	
	@Override
	public Set<Arquivo> revert(Collection<ArquivoDTO> source) {
		
		final Set<Arquivo> target = new HashSet<Arquivo>();
		
		for (ArquivoDTO arquivoDTO : source) {
			Arquivo arquivo = this.getArquivo(arquivoDTO.getId());
			arquivo.setDescricao(arquivoDTO.getDescricao());
			arquivo.setUrlArquivo(arquivoDTO.getUrlArquivo());
			arquivo.setTipo(arquivoDTO.getTipo());
			target.add(arquivo);
		}
		
		return target;
	}
	
	private Arquivo getArquivo(Long id) {
		return id == null ? new Arquivo() : this.arquivoDao.getOne(id);
	}	
}