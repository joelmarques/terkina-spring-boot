package br.com.terkina.module.historico.escolar;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import br.com.terkina.base.utils.DateUtils;
import br.com.terkina.module.animal.Animal;
import br.com.terkina.module.arquivo.Arquivo;
import br.com.terkina.module.arquivo.TipoArquivoEnum;
import br.com.terkina.module.experimento.projeto.ProjetoPesquisa;
import lombok.Getter;

@Getter
public class HistoricoEscolar implements IHistoricoEscolar {
	
	private static final String DESCONHECIDO_A = "desconhecido(a)";
	
	private String nome;
	private String codigo;
	private String sexo;
	private String urlFoto;
	private String especie;
	private String nascimento;
	private String idade;
	private boolean aniversariante;
	private String proveniencia;
	private Collection<IProjeto> projetos;
	private Collection<String> videos;
	private Collection<String> imagens;
	
	public HistoricoEscolar(final Animal animal, final Collection<ProjetoPesquisa> projetos) {
		super();
		this.nome = animal.getNome();
		this.codigo = animal.getCodigo();
		this.sexo = Objects.toString(animal.getSexo(), DESCONHECIDO_A);
		this.urlFoto = animal.getUrlFoto();
		this.especie = Objects.toString(animal.getTipoDeAnimal(), DESCONHECIDO_A);
		this.nascimento = DateUtils.format(animal.getDataDeNascimento());
		this.idade = StringUtils.defaultIfBlank(DateUtils.calculateAge(animal.getDataDeNascimento()), DESCONHECIDO_A);
		this.aniversariante = DateUtils.isBirthday(animal.getDataDeNascimento());
		this.proveniencia = Objects.toString(animal.getOrigem(), DESCONHECIDO_A);
		this.projetos = this.converterProjetos(projetos);
		this.videos = this.converterVideos(animal.getArquivos());
		this.imagens = this.converterImagens(animal.getArquivos());
	}
	
	private Collection<IProjeto> converterProjetos(final Collection<ProjetoPesquisa> projetos) {
		
		return Optional.ofNullable(projetos).orElse(Collections.emptyList())
				.stream().map(Projeto::new).collect(Collectors.toList());
	}

	private Collection<String> converterVideos(final Collection<Arquivo> arquivos) {
		
		return Optional.ofNullable(arquivos).orElse(Collections.emptyList())
				.stream()
				.filter(a -> TipoArquivoEnum.VIDEO.equals(a.getTipo()))
				.map(a -> StringUtils.replace(a.getUrlArquivo(), "watch?v=", "embed/"))
				.collect(Collectors.toList());
	}
	
	private Collection<String> converterImagens(final Collection<Arquivo> arquivos) {
		
		return Optional.ofNullable(arquivos).orElse(Collections.emptyList())
				.stream()
				.filter(a -> TipoArquivoEnum.IMAGEM.equals(a.getTipo()))
				.map(Arquivo::getUrlArquivo)
				.collect(Collectors.toList());
	}
}