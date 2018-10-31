package br.com.terkina.module.experimento.sessao;

import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import br.com.terkina.base.entity.AbstractEntity;
import br.com.terkina.module.animal.Animal;
import br.com.terkina.module.arquivo.Arquivo;
import br.com.terkina.module.disciplina.Disciplina;
import br.com.terkina.module.experimento.projeto.ProjetoPesquisa;
import br.com.terkina.module.integrante.Integrante;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="SESSAO_EXPERIMENTO")
@NoArgsConstructor
@Getter @Setter
@NamedNativeQueries({
	@NamedNativeQuery(name="SessaoExperimento.findAllByProject",
			  		  query="select sessao.id as id, disciplina.nome as disciplina, sessao.data_sessao as dataSessao"
			  		  		+ " from sessao_experimento sessao"
			  		  		+ " left outer join disciplina disciplina on (sessao.id_disciplina = disciplina.id)"
			  		  		+ " where sessao.id_projeto = ?1")	
})
public class SessaoExperimento extends AbstractEntity<Long> {

	private static final long serialVersionUID = -1161371549047517702L;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PROJETO", nullable=false)
	private ProjetoPesquisa projeto;

	@ManyToOne
	@JoinColumn(name="ID_DISCIPLINA", nullable=false)
	private Disciplina disciplina;
	
	@Column(name="DATA_SESSAO", nullable=false)
	private Date dataSessao;
	
	@Column(name="OBSERVACOES", length=5000)
	private String observacoes;
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "SESSAO_PESQUISADOR", 
        joinColumns = @JoinColumn(name = "ID_SESSAO_EXPERIMENTO", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "ID_PESQUISADOR", referencedColumnName = "id")) 
    private Set<Integrante> pesquisadores;
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name	= "SESSAO_ANIMAL", 
    	joinColumns	= @JoinColumn(name="ID_SESSAO_EXPERIMENTO", referencedColumnName = "id"), 
    	inverseJoinColumns = @JoinColumn(name="ID_ANIMAL", referencedColumnName = "id"))
	private Set<Animal> animais;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinTable(name = "SESSAO_ARQUIVO", 
        joinColumns = @JoinColumn(name = "ID_SESSAO", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "ID_ARQUIVO", referencedColumnName = "id"))
	@OrderBy("tipo")
	private Set<Arquivo> arquivos = new HashSet<Arquivo>();

	public void setArquivos(Set<Arquivo> arquivos) {
		this.arquivos.clear();
		if (arquivos != null) {
			this.arquivos.addAll(arquivos);
		}
	}

}