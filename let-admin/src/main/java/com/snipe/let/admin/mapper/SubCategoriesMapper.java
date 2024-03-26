package com.snipe.let.admin.mapper;

import org.springframework.stereotype.Component;

import com.snipe.let.admin.domain.SubCategoriesDomain;
import com.snipe.let.admin.model.SubCategoriesModel;

@Component
public class SubCategoriesMapper extends AbstractModelMapper<SubCategoriesModel, SubCategoriesDomain> {

	@Override
	public Class<SubCategoriesModel> entityType() {
		// TODO Auto-generated method stub
		return SubCategoriesModel.class;
	}

	@Override
	public Class<SubCategoriesDomain> modelType() {
		// TODO Auto-generated method stub
		return SubCategoriesDomain.class;
	}

}
