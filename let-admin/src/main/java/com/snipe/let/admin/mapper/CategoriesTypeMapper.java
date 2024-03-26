package com.snipe.let.admin.mapper;

import org.springframework.stereotype.Component;

import com.snipe.let.admin.domain.CategoriesTypeDomain;
import com.snipe.let.admin.model.CategoriesTypeModel;

@Component
public class CategoriesTypeMapper extends AbstractModelMapper<CategoriesTypeModel, CategoriesTypeDomain> {

	@Override
	public Class<CategoriesTypeModel> entityType() {
		// TODO Auto-generated method stub
		return CategoriesTypeModel.class;
	}

	@Override
	public Class<CategoriesTypeDomain> modelType() {
		// TODO Auto-generated method stub
		return CategoriesTypeDomain.class;
	}

}
