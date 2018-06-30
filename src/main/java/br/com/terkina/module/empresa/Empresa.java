package br.com.terkina.module.empresa;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import br.com.terkina.base.model.EntityBase;
import br.com.terkina.module.arquivo.Arquivo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Empresa extends EntityBase<Long> {

	private static final long serialVersionUID = -8799122525545330960L;
	
	@Column(name="IDENTIFICADOR", unique = true)
	private String identificador;

	@Column(name="NOME", length = 100, nullable = false)
	private String nome;

	@Column(name="SIGLA", length = 20, nullable = false)
	private String sigla;

	@Column(name="TELEFONE", length = 40)
	private String telefone;
	
	@Column(name="EMAIL", length = 100)
	private String email;
	
	@Column(name="ENDERECO")
	private String endereco;
	
	@Column(name="HORARIO_FUNCIONAMENTO")
	private String horarioDeFuncionamento;
	
	@Column(name="DESCRICAO", length = 5000)
	private String descricao;
	
	@Column(name="OBJETIVO_UM", length = 500)
	private String objetivoUm;
	
	@Column(name="OBJETIVO_DOIS", length = 500)
	private String objetivoDois;
	
	@Column(name="OBJETIVO_TRES", length = 500)
	private String objetivoTres;
	
	@Column(name="URL_VIDEO", length = 300)
	private String urlVideo;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinTable(name = "EMPRESA_ARQUIVO", 
        joinColumns = @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "ID_ARQUIVO", referencedColumnName = "id"))
	@OrderBy("tipo")
	private Set<Arquivo> arquivos;
}