package com.snipe.let.admin.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.snipe.let.admin.domain.CategoriesTypeDomain;

@JsonInclude(Include.NON_DEFAULT)

public class CategoriesModel implements Serializable {

	private static final long serialVersionUID = -6667630235606843632L;

	private long categoriesId;
	private String categoriesName;
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

	public CategoriesTypeDomain getCategoriesTypeDomain() {
		return categoriesTypeDomain;
	}

	public void setCategoriesTypeDomain(CategoriesTypeDomain categoriesTypeDomain) {
		this.categoriesTypeDomain = categoriesTypeDomain;
	}

	

}
