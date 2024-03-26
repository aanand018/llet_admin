package com.snipe.let.admin.service;

import java.util.List;

import com.snipe.let.admin.domain.CategoriesDomain;
import com.snipe.let.admin.model.CategoriesModel;

public interface CategoriesService {

	public String addCategories(CategoriesModel categoriesModel) throws Exception;

	public List<CategoriesModel> getCategories() throws Exception;

	public CategoriesModel getCategoriesById(long categoriesId) throws Exception;

	public String updateCategories(CategoriesModel categoriesModel) throws Exception;

	public String deleteCategories(long categoriesId) throws Exception;

	public List<CategoriesDomain> getCategoriesByTypeId(long categoriesTypeId) throws Exception;

}
