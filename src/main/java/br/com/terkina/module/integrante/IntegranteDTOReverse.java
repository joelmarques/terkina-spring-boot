package br.com.terkina.module.integrante;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.terkina.base.converter.Reverse;
import br.com.terkina.base.model.Item;
import br.com.terkina.base.utils.PasswordUtils;
import br.com.terkina.module.curso.Curso;
import br.com.terkina.module.curso.CursoDao;
import br.com.terkina.module.user.ProfileType;
import br.com.terkina.module.user.Profile;
import br.com.terkina.module.user.ProfileDao;

@Component
public class IntegranteDTOReverse implements Reverse<IntegranteDTO, Integrante> {
	
	@Autowired
	private IntegranteDao integranteDao;
	
	@Autowired
	private CursoDao cursoDao;
	
	@Autowired
	private ProfileDao rolesDao;

	@Override
	public Integrante revert(IntegranteDTO source) {
		
		Integrante target = this.getIntegrante(source.getId());
		target.setNome(source.getNome());
		target.setCpf(source.getCpf());
		target.setEmail(source.getEmail());
		target.setTelefone(source.getTelefone());
		target.setLinkedin(source.getLinkedin());
		target.setFacebook(source.getFacebook());
		target.setCurriculoLattes(source.getCurriculoLattes());
		target.setResumo(source.getResumo());
		target.setUrlFoto(source.getUrlFoto());
		target.setEnable(source.getEnable());
		target.setRoles(new HashSet<Profile>(this.rolesDao.findAllById(Item.findIds(source.getRoles()))));
		target.setCursos(new HashSet<Curso>(this.cursoDao.findAllById(Item.findIds(source.getCursos()))));
		target.setOrientadores(new HashSet<Integrante>(this.integranteDao.findAllById(Item.findIds(source.getOrientadores()))));
		this.definirSenhaDeAcesso(source, target);
		return target;
	}
	
	private Integrante getIntegrante(final Long id) {
		return id == null ? new Integrante() : this.integranteDao.getOne(id);
	}
	
	private void definirSenhaDeAcesso(final IntegranteDTO source, final Integrante target) {
		
		if (this.isCriarSenha(source)) {
			if (StringUtils.isBlank(target.getPassword()) || this.isAlterouEmail(source, target)) {
				source.setPassword(PasswordUtils.getRandomPassword());
				target.setPassword(PasswordUtils.encode(source.getPassword()));
			}
		} else {
			source.setPassword(null);
			target.setPassword(null);
		}
	}
	
	private boolean isCriarSenha(final IntegranteDTO source) {
		
		return StringUtils.isNotBlank(source.getEmail())
				&& Boolean.TRUE.equals(source.getEnable())
				&& this.possuiPerfilParaLogin(source);
	}
	
	private boolean possuiPerfilParaLogin(final IntegranteDTO source) {
		
		List<String> perfisPermitidos = Arrays.asList(ProfileType.ADMIN.getDescricao(), ProfileType.ORIENTADOR.getDescricao(), ProfileType.PESQUISADOR.getDescricao());
		
		return source.getRoles().stream().anyMatch(r -> perfisPermitidos.contains(r.getDescricao()));
	}
	
	private boolean isAlterouEmail(final IntegranteDTO source, final Integrante target) {
		return !source.getEmail().equals(target.getEmail());
	}
	
}