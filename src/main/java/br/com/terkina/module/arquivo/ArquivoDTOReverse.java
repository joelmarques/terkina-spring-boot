package br.com.terkina.module.arquivo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.terkina.base.converter.Reverse;
import br.com.terkina.module.user.UserService;

@Component
public class ArquivoDTOReverse implements Reverse<Collection<ArquivoDTO>, Set<Arquivo>> {
	
	@Autowired
	private ArquivoDao arquivoDao;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Set<Arquivo> revert(Collection<ArquivoDTO> source) {
		
		final Set<Arquivo> target = new HashSet<Arquivo>();
		
		final Long tenancy = this.userService.getCurrentTenancy();
		
		for (ArquivoDTO arquivoDTO : source) {
			Arquivo arquivo = this.getArquivo(arquivoDTO.getId());
			arquivo.setDescricao(arquivoDTO.getDescricao());
			arquivo.setUrlArquivo(arquivoDTO.getUrlArquivo());
			arquivo.setTipo(arquivoDTO.getTipo());
			arquivo.setTenancy(tenancy);
			target.add(arquivo);
		}
		
		return target;
	}
	
	private Arquivo getArquivo(Long id) {
		return id == null ? new Arquivo() : this.arquivoDao.getOne(id);
	}	
}