package br.com.terkina.base.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import br.com.terkina.base.listener.AbstractEntityListener;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class, AbstractEntityListener.class})
@EqualsAndHashCode(of = "id")
public abstract class EntityBase<PK> implements Serializable {

	@Id
	@Column(name="ID")
	@Getter @Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private PK id;
	
	@CreatedDate @Getter @Setter
	@Column(name = "CREATED_DATE", nullable = false, updatable = false)
    private Date createdDate;
 
	@LastModifiedDate @Getter @Setter
    @Column(name = "LAST_MODIFIED_DATE", nullable = true, updatable = true)
    private Date lastModifiedDate;
	
//	@Column(name = "CREATED_BY", nullable = false, updatable = false)
//	@CreatedBy
//	private String createdBy;
//
//	@Column(name = "MODIFIED_BY", nullable = true, updatable = true)
//	@LastModifiedBy
//	private String modifiedBy;

	@Getter @Setter
	@Column(name = "TENANCY", nullable = false, updatable = false)
	private Long tenancy;
}