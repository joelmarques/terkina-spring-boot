package br.com.terkina.module.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.terkina.base.controller.SimpleRestBaseController;
import br.com.terkina.module.arquivo.Arquivo;
import br.com.terkina.module.arquivo.TipoArquivoEnum;
import br.com.terkina.module.user.UserService;

@RestController
@RequestMapping("/resources/empresas")
public class EmpresaResource extends SimpleRestBaseController<Empresa, Long, EmpresaDao> {
	
	@Autowired
	private UserService userService;
	
	@Override
	@PostMapping
	public Empresa save(@RequestBody Empresa empresa) {
		
		this.definirTenancy(empresa);
		
		return super.save(empresa);
	}

	private void definirTenancy(Empresa empresa) {
		
		Long tenancy = this.userService.getCurrentTenancy();
		
		empresa.setTenancy(tenancy);
		
		if (empresa.getArquivos() != null) {
			for (Arquivo arquivo : empresa.getArquivos()) {
				arquivo.setTenancy(tenancy);
			}
		}
	}
	
	@GetMapping("empresaDoUsuarioLogado")
	public Empresa getEmpresaDoUsuarioLogado() {
		return repository.findByTenancy(this.userService.getCurrentTenancy());
	}
	
	@GetMapping("tiposArquivos")
	public TipoArquivoEnum[] getTiposArquivos() {
		return TipoArquivoEnum.values();
	}

}