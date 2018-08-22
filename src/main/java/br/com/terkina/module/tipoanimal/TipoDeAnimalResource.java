package br.com.terkina.module.tipoanimal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.terkina.base.controller.SimpleRestBaseController;

@RestController
@RequestMapping("/resources/tiposDeAnimal")
public class TipoDeAnimalResource extends SimpleRestBaseController<TipoDeAnimal, Long, TipoDeAnimalDao> {

}