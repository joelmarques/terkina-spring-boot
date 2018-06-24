package br.com.terkina.module.curso;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.terkina.base.rest.SimpleRestBaseController;

@RestController
@RequestMapping("/resources/curso")
public class CursoResource extends SimpleRestBaseController<Curso, Long, CursoDao> {
	
}