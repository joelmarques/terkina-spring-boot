package br.com.terkina.module.instituicao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.terkina.base.rest.SimpleRestBaseController;

@RestController
@RequestMapping("/resources/instituicao")
public class InstituicaoResource extends SimpleRestBaseController<Instituicao, Long, InstituicaoDao> {
	
}