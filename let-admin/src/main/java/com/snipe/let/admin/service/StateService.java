package com.snipe.let.admin.service;

import java.util.List;

import com.snipe.let.admin.domain.StateDomain;
import com.snipe.let.admin.model.StateModel;

public interface StateService {

	public String addState(StateModel stateModel) throws Exception;

	public List<StateDomain> getStateList() throws Exception;

	public StateDomain getStateListById(long stateId) throws Exception;

	public List<StateDomain> getStatedetails(long countryId) throws Exception;

	public String updateState(StateModel stateModel) throws Exception;

	public String deleteStateById(long stateId) throws Exception;

	public StateModel stateCount() throws Exception;

}
