package br.com.terkina.module.experimento.projeto;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.terkina.base.model.EntityBase;
import br.com.terkina.module.animal.Animal;
import br.com.terkina.module.experimento.sessao.SessaoExperimento;
import br.com.terkina.module.experimento.trabalho.TrabalhoAcademico;
import br.com.terkina.module.integrante.Integrante;
import br.com.terkina.module.tipopesquisa.TipoDePesquisa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PROJETO_PESQUISA")
@NoArgsConstructor
@Getter @Setter
@NamedNativeQueries({
	@NamedNativeQuery(name="ProjetoPesquisa.findAllByTenancy",
			  		  query="select projeto.id as id, projeto.titulo as titulo, tipo.nome as tipoPesquisa"
			  		  		+ " from projeto_pesquisa projeto"
			  		  		+ " left outer join tipo_pesquisa tipo on (projeto.id_tipo_pesquisa = tipo.id)"
			  		  		+ " where projeto.tenancy = ?1")	
})
@NamedQueries({
	@NamedQuery(name="ProjetoPesquisa.findAllByAnimal",
			  		  query="select p from ProjetoPesquisa p where :animal member of p.animais")	
})
public class ProjetoPesquisa extends EntityBase<Long> {

	private static final long serialVersionUID = -8303243828412559887L;

	@Column(name="TITULO", length = 300, nullable = false)
	private String titulo;

	@Column(name="RESUMO", length = 5000, nullable = false)
	private String resumo;

	@Column(name="DATA_INICIO")
	private Date dataDeInicio;

	@Column(name="DATA_CONCLUSAO")
	private Date dataDeConclusao;

	@ManyToOne
	@JoinColumn(name = "ID_TIPO_PESQUISA")
	private TipoDePesquisa tipoPesquisa;

	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "PROJETO_ORIENTADOR", 
        joinColumns = @JoinColumn(name = "ID_PROJETO", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "ID_ORIENTADOR", referencedColumnName = "id")) 
    private Set<Integrante> orientadores;
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "PROJETO_PESQUISADOR", 
        joinColumns = @JoinColumn(name = "ID_PROJETO", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "ID_PESQUISADOR", referencedColumnName = "id")) 
    private Set<Integrante> pesquisadores;
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name	= "PROJETO_ANIMAL", 
    	joinColumns	= @JoinColumn(name="ID_PROJETO", referencedColumnName = "id"), 
    	inverseJoinColumns = @JoinColumn(name="ID_ANIMAL", referencedColumnName = "id"))
	private Set<Animal> animais;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="projeto")
	private Set<SessaoExperimento> sessoesExperimento;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="projeto")
	private Set<TrabalhoAcademico> trabalhosAcademicos;

}