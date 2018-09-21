package br.com.terkina.module.publico.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.terkina.mail.MessageBuilder;
import br.com.terkina.mail.SmtpMailSender;
import br.com.terkina.module.historico.escolar.IHistoricoEscolar;

@RestController
@RequestMapping("/publico/sites")
@CrossOrigin(origins = "http://eepufpa.com.br", maxAge = 3600)
public class SiteResource {
	
	@Autowired	
	private SiteService siteService;
	
	@Autowired
	private SmtpMailSender smtpMailSender;
	
	@GetMapping
	public ISite getSite(@RequestParam("identificador") String identificador) {
		return this.siteService.buscarSite(identificador);
	}
	
	@GetMapping("historicos")
	public IHistoricoEscolar getHistoricoEscolar(@RequestParam("idAnimal") Long idAnimal) {
		return this.siteService.buscarHistoricoEscolar(idAnimal);
	}
	
	@PostMapping
	public void enviarMensagem(@RequestBody Visitante visitante) {
		this.smtpMailSender.send(new MessageBuilder().build(visitante));
		this.siteService.salvarVisitante(visitante);
	}
	
}