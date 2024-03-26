package com.snipe.let.admin.dao;

import java.util.List;

import com.snipe.let.admin.domain.CountryDomain;

public interface CountryDAO {

	public String addCountry(CountryDomain countryDomain) throws Exception;

	public List<CountryDomain> getCountryList() throws Exception;

	public CountryDomain getCountryListById(long cityID) throws Exception;

	public String updateCountry(CountryDomain countryDomain) throws Exception;

	public String deleteCountryById(long countryId) throws Exception;

}
