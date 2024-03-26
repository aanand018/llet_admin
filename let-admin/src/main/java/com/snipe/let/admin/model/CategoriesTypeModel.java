package com.snipe.let.admin.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class CategoriesTypeModel implements Serializable {
	private static final long serialVersionUID = -6667630235606843632L;

	private long categoriesTypeId;
	private String categoriesTypeName;

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

}
