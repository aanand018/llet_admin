package com.snipe.let.admin.mapper;

import org.springframework.stereotype.Component;

import com.snipe.let.admin.domain.SubCategoriesImageDomain;
import com.snipe.let.admin.model.SubCategoriesImageModel;

@Component
public class SubCategoriesImageMapper extends AbstractModelMapper<SubCategoriesImageModel, SubCategoriesImageDomain> {

	@Override
	public Class<SubCategoriesImageModel> entityType() {
		return SubCategoriesImageModel.class;
	}

	@Override
	public Class<SubCategoriesImageDomain> modelType() {
		return SubCategoriesImageDomain.class;
	}

}
