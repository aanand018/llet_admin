package com.snipe.let.admin.service;

import java.util.List;

import com.snipe.let.admin.domain.SubCategoriesDomain;
import com.snipe.let.admin.model.SubCategoriesModel;

public interface SubCategoriesService {

	public SubCategoriesDomain addSubCategories(SubCategoriesModel subCategoriesModel) throws Exception;

	public List<SubCategoriesModel> getSubCategories() throws Exception;

	public SubCategoriesModel getSubCategoriesById(long SubCategoriesId) throws Exception;

	public String updateSubCategories(SubCategoriesModel subCategoriesModel) throws Exception;

	public String deleteSubCategories(long subCategoriesId) throws Exception;

	public List<SubCategoriesModel> getSubCategoriesByCatId(long categoriesId) throws Exception;

	public List<SubCategoriesModel> getSubCategoriesByCatTypeId(long categoriesTypeId) throws Exception;

	public List<SubCategoriesModel> getCategoryStock(String userId, long categoriesId) throws Exception;

	public List<SubCategoriesModel> getCategoryTypeStock(String userId, long categoriesTypeId) throws Exception;

}
