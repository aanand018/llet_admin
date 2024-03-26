package com.snipe.let.admin.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snipe.let.admin.dao.CategoriesDAO;
import com.snipe.let.admin.domain.CategoriesDomain;
import com.snipe.let.admin.mapper.CategoriesMapper;
import com.snipe.let.admin.model.CategoriesModel;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	CategoriesDAO categoriesDAO;

	@Autowired
	CategoriesMapper categoriesMapper;

	@Override
	public String addCategories(CategoriesModel categoriesModel) throws Exception {
		CategoriesDomain categoriesDomain = new CategoriesDomain();
		BeanUtils.copyProperties(categoriesModel, categoriesDomain);
		String response = categoriesDAO.addCategories(categoriesDomain);
		return response;
	}

	@Override
	public List<CategoriesModel> getCategories() throws Exception {
		List<CategoriesDomain> categoriesDomain = categoriesDAO.getCategories();
		return categoriesMapper.entityList(categoriesDomain);
	}

	@Override
	public CategoriesModel getCategoriesById(long categoriesId) throws Exception {
		CategoriesModel categoriesModel = new CategoriesModel();
		CategoriesDomain categoriesDomain = categoriesDAO.getCategoriesById(categoriesId);
		BeanUtils.copyProperties(categoriesDomain, categoriesModel);
		return categoriesModel;
	}

	@Override
	public String updateCategories(CategoriesModel categoriesModel) throws Exception {
		CategoriesDomain categoriesDomain = new CategoriesDomain();
		BeanUtils.copyProperties(categoriesModel, categoriesDomain);
		return categoriesDAO.updateCategories(categoriesDomain);

	}

	@Override
	public String deleteCategories(long categoriesId) throws Exception {
		return categoriesDAO.deleteCategories(categoriesId);
	}

	@Override
	public List<CategoriesDomain> getCategoriesByTypeId(long categoriesTypeId) throws Exception {
		List<CategoriesDomain> categoriesDomain = categoriesDAO.getCategoriesByTypeId(categoriesTypeId);
		return categoriesDomain;
	}

}
