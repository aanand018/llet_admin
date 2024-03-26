package com.snipe.let.admin.dao;

import java.util.List;

import com.snipe.let.admin.domain.CityDomain;
import com.snipe.let.admin.response.Response;

public interface CityDAO {

	public String addCity(CityDomain cityDomain) throws Exception;

	public List<CityDomain> getCityList() throws Exception;
	
	public CityDomain getCityListById(long cityID) throws Exception;
	
	public String updateCity(CityDomain cityDomain) throws Exception;
	
	public String deleteCityById(long cityId)throws Exception;

	public List<CityDomain> getCityList(long stateId) throws Exception;
}

