package com.snipe.let.admin.service;

import java.util.List;

import com.snipe.let.admin.model.CountryModel;

public interface CountryService {

	public String addCountry(CountryModel countryModel) throws Exception;

	public List<CountryModel> getCountryList() throws Exception;

	public CountryModel getCountryListById(long countryId) throws Exception;

	public String updateCountry(CountryModel countryModel) throws Exception;

	public String deleteCountryById(long countryId) throws Exception;

}
