package com.snipe.let.admin.dao;

import java.util.List;

import com.snipe.let.admin.domain.CategoriesTypeDomain;

public interface CategoriesTypeDAO {

	public String addCategoriesType(CategoriesTypeDomain categoriesTypeDomain) throws Exception;

	public List<CategoriesTypeDomain> getCategoriesType() throws Exception;

	public CategoriesTypeDomain getCategoriesTypeById(long categoriesTypeId) throws Exception;

	public String updateCategoriesType(CategoriesTypeDomain categoriesTypeDomain) throws Exception;

	public String deleteCategoriesType(long categoriesTypeId) throws Exception;

}
