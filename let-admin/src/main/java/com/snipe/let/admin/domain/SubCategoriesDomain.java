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
@Table(name = "subCategories")
public class SubCategoriesDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4324999829375534666L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subCategoriesId")
	private long subCategoriesId;

	@Column(name = "subCategoriesName")
	private String subCategoriesName;

	@Column(name = "creationDate")
	@CreationTimestamp
	private LocalDateTime creationDate;

	@Column(name = "modificationDate")
	@UpdateTimestamp
	private LocalDateTime modificationDate;

	@ManyToOne
	@JoinColumn(name = "categoriesId")
	private CategoriesDomain categoriesDomain;

	@ManyToOne
	@JoinColumn(name = "categoriesTypeId")
	private CategoriesTypeDomain categoriesTypeDomain;

	@Column(name = "price")
	private Double price;

	@Column(name = "description")
	private String description;

	@Column(name = "Quantity")
	private String Quantity;

	@Column(name = "serve")
	private int serve;

	@Column(name = "detailDescription")
	private String detailDescription;

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getServe() {
		return serve;
	}

	public void setServe(int serve) {
		this.serve = serve;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	public CategoriesDomain getCategoriesDomain() {
		return categoriesDomain;
	}

	public void setCategoriesDomain(CategoriesDomain categoriesDomain) {
		this.categoriesDomain = categoriesDomain;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getSubCategoriesId() {
		return subCategoriesId;
	}

	public void setSubCategoriesId(long subCategoriesId) {
		this.subCategoriesId = subCategoriesId;
	}

	public String getSubCategoriesName() {
		return subCategoriesName;
	}

	public void setSubCategoriesName(String subCategoriesName) {
		this.subCategoriesName = subCategoriesName;
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

}
