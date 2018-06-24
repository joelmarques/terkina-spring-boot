package br.com.terkina.module.localizacao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.terkina.base.rest.SimpleRestBaseController;

@RestController
@RequestMapping("/resources/localizacao")
public class LocalizacaoResource extends SimpleRestBaseController<Localizacao, Long, LocalizacaoDao> {

}