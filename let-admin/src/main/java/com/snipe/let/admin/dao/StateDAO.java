package com.snipe.let.admin.dao;

import java.util.List;

import com.snipe.let.admin.domain.StateDomain;

public interface StateDAO {

	public String addState(StateDomain stateDomain) throws Exception;

	public List<StateDomain> getStateList() throws Exception;

	public StateDomain getStateListById(long stateId) throws Exception;

	public List<StateDomain> getStatedetails(long countryId) throws Exception;

	public String updateState(StateDomain stateDomain) throws Exception;

	public String deleteStateById(long stateId) throws Exception;

}
