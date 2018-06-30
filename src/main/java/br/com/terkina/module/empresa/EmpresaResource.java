package br.com.terkina.module.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.terkina.base.rest.SimpleRestBaseController;
import br.com.terkina.module.arquivo.TipoArquivoEnum;
import br.com.terkina.module.user.UserService;

@RestController
@RequestMapping("/resources/empresas")
public class EmpresaResource extends SimpleRestBaseController<Empresa, Long, EmpresaDao> {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("empresaDoUsuarioLogado")
	public Empresa getEmpresaDoUsuarioLogado() {
		return repository.findByTenancy(this.userService.getCurrentTenancy());
	}
	
	@GetMapping("tiposArquivos")
	public TipoArquivoEnum[] getTiposArquivos() {
		return TipoArquivoEnum.values();
	}

}