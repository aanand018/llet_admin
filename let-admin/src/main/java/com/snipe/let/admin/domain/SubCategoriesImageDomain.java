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
@Table(name = "subCategoriesImage")
public class SubCategoriesImageDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5225952016742268858L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subCategoriesImageId")
	private long subCategoriesImageId;

	@Column(name = "subCategoriesId")
	private long subCategoriesId;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "size")
	private long size;

	@Column(name = "path")
	private String path;

	@Column(name = "creationDate")
	@CreationTimestamp
	private LocalDateTime creationDate;

	@Column(name = "modificationDate")
	@UpdateTimestamp
	private LocalDateTime modificationDate;


	public long getSubCategoriesId() {
		return subCategoriesId;
	}

	public void setSubCategoriesId(long subCategoriesId) {
		this.subCategoriesId = subCategoriesId;
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


	public long getSubCategoriesImageId() {
		return subCategoriesImageId;
	}

	public void setSubCategoriesImageId(long subCategoriesImageId) {
		this.subCategoriesImageId = subCategoriesImageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
