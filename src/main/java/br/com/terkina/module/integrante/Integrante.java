package br.com.terkina.module.integrante;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import br.com.terkina.base.entity.AbstractEntity;
import br.com.terkina.module.curso.Curso;
import br.com.terkina.module.user.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
@NamedNativeQueries({
	@NamedNativeQuery(name="Integrante.findTenancyByEmail",
			  		  query="select i.tenancy from integrante i where i.email = ?1"),
	
	@NamedNativeQuery(name="Integrante.findAllByProject",
					  query="select i.id as id, i.nome as descricao"
					  		+ " from integrante i"
					  		+ " where i.id in"
					  		+ " (select pp.id_pesquisador from projeto_pesquisador pp where pp.id_projeto = ?1)"),
	
	@NamedNativeQuery(name="Integrante.findAllByProfileAndTenancy",
					  query="select i.id as id, i.nome as descricao"
					  		+ " from integrante i"
					  		+ " where i.id in"
					  		+ " (select ir.id_integrante from integrante_role ir where ir.id_role in "
					  		+ " 	(select r.id from profile r"
					  		+ " 	where r.name = ?1))"
					  		+ " and i.tenancy = ?2"),
	
	@NamedNativeQuery(name="Integrante.findAllByProfileAndTenancyAndEnable",
					  query="select i.id id, i.nome nome, i.resumo resumo,"
					  		+ " i.curriculo_lattes curriculoLattes, i.email email,"
					  		+ " i.facebook facebook, i.url_foto urlFoto"
					  		+ " from integrante i"
					  		+ " where i.id in"
					  		+ " (select ir.id_integrante from integrante_role ir where ir.id_role in "
					  		+ "	 	(select r.id from profile r"
					  		+ "  	where r.name = ?1))"
					  		+ "	and i.tenancy = ?2"
					  		+ " and i.enable = ?3"),
	
	@NamedNativeQuery(name="Integrante.findMaxTenancy",
	  				  query="select max(i.tenancy) from integrante i"),
	
})
public class Integrante extends AbstractEntity<Long> {

	private static final long serialVersionUID = -4474286405999680839L;
	
	@Column(name="NOME", length = 100, nullable = false)
	private String nome;
	
	@Column(name="CPF", length = 11)
	private String cpf;
	
	@Column(name="EMAIL", length = 100)
	private String email;
	
	@Column(name="TELEFONE", length = 15)
	private String telefone;
	
	@Column(name="LINKEDIN", length = 100)
	private String linkedin;
	
	@Column(name="FACEBOOK", length = 100)
	private String facebook;
	
	@Column(name="CURRICULO_LATTES", length = 100)
	private String curriculoLattes;
	
	@Column(name="RESUMO", length = 1000)
	private String resumo;
	
	@Column(name="URL_FOTO", length = 300)
	private String urlFoto;
	
	@Column(name="PASSWORD", length = 64)
	private String password;

	@Column(name="ENABLE", nullable = false)
	private Boolean enable;
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "INTEGRANTE_ROLE", 
        joinColumns = @JoinColumn(name = "ID_INTEGRANTE", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "ID_ROLE", referencedColumnName = "id")) 
    private Set<Profile> roles;
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "INTEGRANTE_CURSO", 
        joinColumns = @JoinColumn(name = "ID_INTEGRANTE", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "ID_CURSO", referencedColumnName = "id")) 
    private Set<Curso> cursos;
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "INTEGRANTE_ORIENTADOR", 
        joinColumns = @JoinColumn(name = "ID_INTEGRANTE", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "ID_ORIENTADOR", referencedColumnName = "id")) 
    private Set<Integrante> orientadores;
	
}