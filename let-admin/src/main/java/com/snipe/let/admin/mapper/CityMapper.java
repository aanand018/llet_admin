package com.snipe.let.admin.mapper;

import org.springframework.stereotype.Component;

import com.snipe.let.admin.domain.CityDomain;
import com.snipe.let.admin.model.CityModel;

@Component
public class CityMapper extends AbstractModelMapper<CityModel, CityDomain> {

	@Override
	public Class<CityModel> entityType() {
		// TODO Auto-generated method stub
		return CityModel.class;
	}

	@Override
	public Class<CityDomain> modelType() {
		// TODO Auto-generated method stub
		return CityDomain.class;
	}

}
