package br.com.terkina.module.animal;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.terkina.base.enums.SituacaoEnum;
import br.com.terkina.base.model.EntityBase;
import br.com.terkina.module.arquivo.Arquivo;
import br.com.terkina.module.localizacao.Localizacao;
import br.com.terkina.module.tipoanimal.TipoDeAnimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
@NamedNativeQueries({
	@NamedNativeQuery(name="Animal.findAllByTenancy",
					  query="select a.id as id, a.nome as descricao"
					  		+ " from animal a"
					  		+ " where a.tenancy = ?1"),
	
	@NamedNativeQuery(name="Animal.findAllByProject",
					  query="select a.id as id, a.nome as descricao"
					  		+ " from animal a"
					  		+ " where a.id in"
					  		+ " (select pa.id_animal from projeto_animal pa where pa.id_projeto = ?1)"),
	
	@NamedNativeQuery(name="Animal.findAllByTenancyAndEnable",
					  query="select a.id as id, a.nome as nome, a.codigo as codigo,"
					  		+ " a.sexo as sexo, a.url_foto as urlFoto, a.data_nascimento as dataDeNascimento, l.nome as proveniencia"
					  		+ " from animal a"
					  		+ " left outer join localizacao l on (a.id_origem = l.id)"
					  		+ " where a.tenancy = ?1"
					  		+ " and a.situacao = ?2"
					  		+ " order by a.nome")
})
public class Animal extends EntityBase<Long> {

	private static final long serialVersionUID = 9139783455041858497L;

	@ManyToOne
	@JoinColumn(name = "ID_TIPO_ANIMAL")
	private TipoDeAnimal tipoDeAnimal;

	@Column(name="NOME", length = 100, nullable = false)
	private String nome;

	@Column(name="CODIGO", length = 20, nullable = false)
	private String codigo;
	
	@Enumerated(EnumType.STRING)
	private SexoEnum sexo;

	@Column(name="DATA_NASCIMENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDeNascimento;
	
	@ManyToOne
	@JoinColumn(name = "ID_ORIGEM")
	private Localizacao origem;
	
	@Column(name="DATA_ENTRADA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDeEntrada;	

	@ManyToOne
	@JoinColumn(name = "ID_DESTINO")
	private Localizacao destino;

	@Column(name="DATA_SAIDA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDeSaida;

	@Column(name="CAUSA_SAIDA", length = 500)
	private String causaDaSaida;

	@Column(name="DESCRICAO", length = 500)
	private String descricao;

	@Column(name="URL_FOTO", length = 300)
	private String urlFoto;
	
	@Enumerated(EnumType.STRING)
	private SituacaoEnum situacao;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinTable(name = "ANIMAL_ARQUIVO", 
        joinColumns = @JoinColumn(name = "ID_ANIMAL", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "ID_ARQUIVO", referencedColumnName = "id"))
	@OrderBy("tipo")
	private Set<Arquivo> arquivos;

}