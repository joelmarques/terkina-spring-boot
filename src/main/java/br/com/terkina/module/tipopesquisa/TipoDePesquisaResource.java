package br.com.terkina.module.tipopesquisa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.terkina.base.controller.SimpleRestBaseController;

@RestController
@RequestMapping("/resources/tiposDePesquisa")
public class TipoDePesquisaResource extends SimpleRestBaseController<TipoDePesquisa, Long, TipoDePesquisaDao> {

}