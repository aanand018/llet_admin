package com.snipe.let.admin.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class SubCategoriesImageModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5396949063810607757L;

	private String subCategoriesImageId;
	private long subCategoriesId;
	private String name;
	private String type;
	private long size;
	private String path;

	public String getSubCategoriesImageId() {
		return subCategoriesImageId;
	}

	public void setSubCategoriesImageId(String subCategoriesImageId) {
		this.subCategoriesImageId = subCategoriesImageId;
	}

	public long getSubCategoriesId() {
		return subCategoriesId;
	}

	public void setSubCategoriesId(long subCategoriesId) {
		this.subCategoriesId = subCategoriesId;
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
