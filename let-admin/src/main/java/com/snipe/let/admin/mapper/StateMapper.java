package com.snipe.let.admin.mapper;

import org.springframework.stereotype.Component;

import com.snipe.let.admin.domain.StateDomain;
import com.snipe.let.admin.model.StateModel;

@Component
public class StateMapper extends AbstractModelMapper<StateModel, StateDomain> {

	@Override
	public Class<StateModel> entityType() {
		// TODO Auto-generated method stub
		return StateModel.class;
	}

	@Override
	public Class<StateDomain> modelType() {
		// TODO Auto-generated method stub
		return StateDomain.class;
	}

}
