package com.snipe.let.admin.service;

import java.util.List;

import com.snipe.let.admin.model.CategoriesTypeModel;

public interface CategoriesTypeService {

	public String addCategoriesType(CategoriesTypeModel categoriesTypeModel) throws Exception;

	public List<CategoriesTypeModel> getCategoriesType() throws Exception;

	public CategoriesTypeModel getCategoriesTypeById(long categoriesTypeId) throws Exception;

	public String updateCategoriesType(CategoriesTypeModel categoriesTypeModel) throws Exception;

	public String deleteCategoriesType(long categoriesTypeId) throws Exception;

}
