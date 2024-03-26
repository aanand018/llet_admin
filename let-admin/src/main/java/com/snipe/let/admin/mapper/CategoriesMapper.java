package com.snipe.let.admin.mapper;

import org.springframework.stereotype.Component;

import com.snipe.let.admin.domain.CategoriesDomain;
import com.snipe.let.admin.model.CategoriesModel;

@Component
public class CategoriesMapper extends AbstractModelMapper<CategoriesModel, CategoriesDomain> {

	@Override
	public Class<CategoriesModel> entityType() {
		// TODO Auto-generated method stub
		return CategoriesModel.class;
	}

	@Override
	public Class<CategoriesDomain> modelType() {
		// TODO Auto-generated method stub
		return CategoriesDomain.class;
	}

}




