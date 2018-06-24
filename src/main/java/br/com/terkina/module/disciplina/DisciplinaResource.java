package br.com.terkina.module.disciplina;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.terkina.base.rest.SimpleRestBaseController;

@RestController
@RequestMapping("/resources/disciplinas")
public class DisciplinaResource extends SimpleRestBaseController<Disciplina, Long, DisciplinaDao> {

}