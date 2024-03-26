package com.snipe.let.admin.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "categoriesType")
public class CategoriesTypeDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4324999829375534666L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "categoriesTypeId")
	private long categoriesTypeId;

	@Column(name = "categoriesTypeName")
	private String categoriesTypeName;

	@Column(name = "creationDate")
	@CreationTimestamp
	private LocalDateTime creationDate;
	@Column(name = "modificationDate")
	@UpdateTimestamp
	private LocalDateTime modificationDate;
	
	
	public long getCategoriesTypeId() {
		return categoriesTypeId;
	}
	public void setCategoriesTypeId(long categoriesTypeId) {
		this.categoriesTypeId = categoriesTypeId;
	}
	public String getCategoriesTypeName() {
		return categoriesTypeName;
	}
	public void setCategoriesTypeName(String categoriesTypeName) {
		this.categoriesTypeName = categoriesTypeName;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(LocalDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}

}
