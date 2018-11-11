package br.com.terkina.module.empresa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.terkina.base.mail.SmtpMailSender;
import br.com.terkina.base.mail.TemplateMessage;
import br.com.terkina.base.utils.DateUtils;
import br.com.terkina.module.animal.Animal;
import br.com.terkina.module.animal.AnimalDao;
import br.com.terkina.module.integrante.Integrante;
import br.com.terkina.module.integrante.IntegranteDao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@EnableScheduling
public class AvisoDeAniversarioJob {
	
	@Autowired
	private EmpresaDao empresaDao;
	
	@Autowired
	private AnimalDao animalDao;
	
	@Autowired
	private IntegranteDao integranteDao;
	
	@Autowired
	private SmtpMailSender smtpMailSender;

	@Scheduled(cron = "${spring.cron.expression}")
	public void execute() {
		
		List<Empresa> empresas = this.empresaDao.findAll();
		
		for (Empresa empresa : empresas) {
			
			List<Animal> animais = this.animalDao.findByTenancy(empresa.getTenancy());
			List<Integrante> integrantes = this.integranteDao.findByTenancy(empresa.getTenancy());
			
			for (Animal animal : animais) {
				if (DateUtils.isBirthday(animal.getDataDeNascimento())) {
					this.enviarEmailAosIntegrantes(empresa, integrantes, animal);
				}
			}
		}		
	}

	private void enviarEmailAosIntegrantes(Empresa empresa, List<Integrante> integrantes, Animal animal) {
		
		MessageVO message = new MessageVO();
		message.setTemplateName("feliz-aniversario");
		
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("foto", animal.getUrlFoto());
		variables.put("nome", animal.getNome());
		variables.put("idade", DateUtils.calculateAgeInFullBrazilianPattern(animal.getDataDeNascimento()));
		variables.put("remetente", empresa.getNome());
		
		message.setVariables(variables);
		message.setSubject(empresa.getSigla() + " Não esqueça! Hoje é aniversário de ... " + animal.getNome());
		
		message.setTo(integrantes.stream().map(Integrante::getEmail).toArray(String[]::new));
		
		smtpMailSender.sendWithTemplate(message);
	}
	
	@NoArgsConstructor
	@Getter @Setter
	public class MessageVO implements TemplateMessage {
		
		private String templateName;
		private Map<String, Object> variables;		
		private String subject;
		private String[] to;
		private String body;
	}
}