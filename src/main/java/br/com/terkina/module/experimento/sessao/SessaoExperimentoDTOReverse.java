package br.com.terkina.module.experimento.sessao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.terkina.base.converter.Reverse;
import br.com.terkina.base.entity.Item;
import br.com.terkina.module.animal.Animal;
import br.com.terkina.module.animal.AnimalRepository;
import br.com.terkina.module.arquivo.Arquivo;
import br.com.terkina.module.arquivo.ArquivoDTO;
import br.com.terkina.module.arquivo.ArquivoDTOReverse;
import br.com.terkina.module.disciplina.Disciplina;
import br.com.terkina.module.disciplina.DisciplinaDao;
import br.com.terkina.module.experimento.projeto.ProjetoPesquisa;
import br.com.terkina.module.experimento.projeto.ProjetoPesquisaDao;
import br.com.terkina.module.integrante.Integrante;
import br.com.terkina.module.integrante.IntegranteDao;
import br.com.terkina.module.user.UserService;

@Component
public class SessaoExperimentoDTOReverse implements Reverse<SessaoExperimentoDTO, SessaoExperimento> {
	
	@Autowired
	private SessaoExperimentoDao sessaoExperimentoDao;
	
	@Autowired
	private DisciplinaDao disciplinaDao;
	
	@Autowired
	private IntegranteDao integranteDao;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private ProjetoPesquisaDao projetoPesquisaDao;
	
	@Autowired
	private ArquivoDTOReverse arquivoDTOReverse;
	
	@Autowired
	private UserService userService;

	@Override
	public SessaoExperimento revert(SessaoExperimentoDTO source) {
		
		SessaoExperimento target = this.getSessaoExperimento(source.getId());		
		target.setProjeto(this.reverterProjeto(target.getProjeto(), source.getIdProjeto()));
		target.setDisciplina(this.reverterDisciplina(source.getDisciplina()));
		target.setDataSessao(source.getDataSessao());
		target.setObservacoes(source.getObservacoes());
		target.setPesquisadores(this.reverterPesquisadores(source.getPesquisadores()));
		target.setAnimais(this.reverterAnimais(source.getAnimais()));
		target.setArquivos(this.reverterArquivos(source.getArquivos()));
		this.definirTenancy(target);
		return target;
	}
	
	private void definirTenancy(SessaoExperimento sessaoExperimento) {
		
		Long tenancy = this.userService.getCurrentTenancy();
		
		sessaoExperimento.setTenancy(tenancy);
		
		if (sessaoExperimento.getArquivos() != null) {
			for (Arquivo  arquivo : sessaoExperimento.getArquivos()) {
				arquivo.setTenancy(tenancy);
			}
		}
	}
	
	private SessaoExperimento getSessaoExperimento(final Long id) {
		return id == null ? new SessaoExperimento() : this.sessaoExperimentoDao.getOne(id);
	}
	
	private ProjetoPesquisa reverterProjeto(final ProjetoPesquisa projeto, final Long idProjeto) {
		return projeto != null ? projeto : this.projetoPesquisaDao.getOne(idProjeto);
	}
	
	private Disciplina reverterDisciplina(final Item disciplina) {
		return disciplina == null ? null : this.disciplinaDao.getOne(disciplina.getId());
	}

	private Set<Integrante> reverterPesquisadores(final Collection<Item> pesquisadores) {
		return new HashSet<Integrante>(this.integranteDao.findAllById(Item.findIds(pesquisadores)));
	}
	
	private Set<Animal> reverterAnimais(final Collection<Item> animais) {
		return new HashSet<Animal>(this.animalRepository.findAllById(Item.findIds(animais)));
	}
	
	private Set<Arquivo> reverterArquivos(final Collection<ArquivoDTO> arquivos) {
		return this.arquivoDTOReverse.revert(arquivos);
	}
	
}