package br.com.terkina.base.entity;

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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter
@EntityListeners(value = {AuditingEntityListener.class, AbstractEntityListener.class})
@EqualsAndHashCode(of = "id")
public abstract class AbstractEntity<PK> implements Serializable {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private PK id;
	
	@CreatedDate
	@Column(name = "CREATED_DATE", nullable = false, updatable = false)
    private Date createdDate;
 
	@LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE", nullable = true, updatable = true)
    private Date lastModifiedDate;
	
	@Column(name = "CREATED_BY", nullable = true, updatable = false)
	@CreatedBy
	private String createdBy;

	@Column(name = "MODIFIED_BY", nullable = true, updatable = true)
	@LastModifiedBy
	private String modifiedBy;

	@Column(name = "TENANCY", nullable = false, updatable = false)
	private Long tenancy;
}