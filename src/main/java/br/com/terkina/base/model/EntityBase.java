package br.com.terkina.base.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
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

	@Getter @Setter
	@Column(name = "TENANCY", nullable = false, updatable = false)
	private Long tenancy = Long.valueOf(1);//TODO
}