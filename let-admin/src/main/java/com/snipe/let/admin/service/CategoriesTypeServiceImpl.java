package com.snipe.let.admin.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snipe.let.admin.dao.CategoriesTypeDAO;
import com.snipe.let.admin.domain.CategoriesTypeDomain;
import com.snipe.let.admin.mapper.CategoriesTypeMapper;
import com.snipe.let.admin.model.CategoriesTypeModel;

@Service
public class CategoriesTypeServiceImpl implements CategoriesTypeService {

	@Autowired
	CategoriesTypeDAO categoriesTypeDAO;

	@Autowired
	CategoriesTypeMapper categoriesTypeMapper;

	@Override
	public String addCategoriesType(CategoriesTypeModel categoriesTypeModel) throws Exception {
		CategoriesTypeDomain categoriesTypeDomain = new CategoriesTypeDomain();
		BeanUtils.copyProperties(categoriesTypeModel, categoriesTypeDomain);
		String response = categoriesTypeDAO.addCategoriesType(categoriesTypeDomain);
		return response;
	}

	@Override
	public List<CategoriesTypeModel> getCategoriesType() throws Exception {
		List<CategoriesTypeDomain> categoriesTypeDomain = categoriesTypeDAO.getCategoriesType();
		return categoriesTypeMapper.entityList(categoriesTypeDomain);
	}

	@Override
	public CategoriesTypeModel getCategoriesTypeById(long categoriesTypeId) throws Exception {
		CategoriesTypeModel categoriesTypeModel = new CategoriesTypeModel();
		CategoriesTypeDomain categoriesTypeDomain = categoriesTypeDAO.getCategoriesTypeById(categoriesTypeId);
		BeanUtils.copyProperties(categoriesTypeDomain, categoriesTypeModel);
		return categoriesTypeModel;
	}

	@Override
	public String updateCategoriesType(CategoriesTypeModel categoriesTypeModel) throws Exception {
		CategoriesTypeDomain categoriesTypeDomain = new CategoriesTypeDomain();
		BeanUtils.copyProperties(categoriesTypeModel, categoriesTypeDomain);
		String response = categoriesTypeDAO.updateCategoriesType(categoriesTypeDomain);
		return response;
	}

	@Override
	public String deleteCategoriesType(long categoriesTypeId) throws Exception {
		return categoriesTypeDAO.deleteCategoriesType(categoriesTypeId);
	}
}
