package br.com.terkina.module.experimento.trabalho;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resources/trabalhosAcademicos")
public class TrabalhoAcademicoResource {
	
	@Autowired
	private TrabalhoAcademicoDao trabalhoAcademicoDao;
	
	@Autowired
	private TrabalhoAcademicoDTOConverter converter;
	
	@Autowired
	private TrabalhoAcademicoDTOReverse reverse;
	
	@GetMapping("trabalhosAcademicosPorProjeto")
	public List<TrabalhoAcademicoVO> getTrabalhosAcademicosPorProjeto(@RequestParam("idProjeto") Long idProjeto) {
		return this.trabalhoAcademicoDao.buscarTrabalhosAcademicosPorProjeto(idProjeto);
	}
	
	@GetMapping("/{id}")
	public TrabalhoAcademicoDTO findByID(@PathVariable("id") Long id) {		
		return this.converter.convert(this.trabalhoAcademicoDao.getOne(id));
	}
	
	@PostMapping
	public void save(@RequestBody TrabalhoAcademicoDTO source) {
		this.trabalhoAcademicoDao.save(this.reverse.revert(source));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.trabalhoAcademicoDao.deleteById(id);
	}
	
	@GetMapping("tiposTrabalho")
	public List<TipoTrabalhoEnum> getTiposTrabalho() {
		return Arrays.asList(TipoTrabalhoEnum.values());
	}

}