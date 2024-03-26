package com.snipe.let.admin.service;

import java.util.List;

import com.snipe.let.admin.domain.CityDomain;
import com.snipe.let.admin.model.CityModel;

public interface CityService {

	public String addCity(CityModel cityModel) throws Exception;

	public List<CityDomain> getCityList() throws Exception;

	public CityDomain getCityListById(long cityId) throws Exception;

	public String updateCity(CityModel cityModel) throws Exception;

	public String deleteCityById(long cityId) throws Exception;

	public List<CityDomain> getCityList(long stateId) throws Exception;

}
