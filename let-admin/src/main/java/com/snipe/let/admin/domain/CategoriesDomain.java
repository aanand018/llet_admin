package com.snipe.let.admin.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "categories")
public class CategoriesDomain implements Serializable {

	private static final long serialVersionUID = -4324999829375534666L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "categoriesId")
	private long categoriesId;

	@Column(name = "categoriesName")
	private String categoriesName;

	@Column(name = "creationDate")
	@CreationTimestamp
	private LocalDateTime creationDate;

	@Column(name = "modificationDate")
	@UpdateTimestamp
	private LocalDateTime modificationDate;

	@ManyToOne
	@JoinColumn(name = "categoriesTypeId")
	private CategoriesTypeDomain categoriesTypeDomain;

	public long getCategoriesId() {
		return categoriesId;
	}

	public void setCategoriesId(long categoriesId) {
		this.categoriesId = categoriesId;
	}

	public String getCategoriesName() {
		return categoriesName;
	}

	public void setCategoriesName(String categoriesName) {
		this.categoriesName = categoriesName;
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

	public CategoriesTypeDomain getCategoriesTypeDomain() {
		return categoriesTypeDomain;
	}

	public void setCategoriesTypeDomain(CategoriesTypeDomain categoriesTypeDomain) {
		this.categoriesTypeDomain = categoriesTypeDomain;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
