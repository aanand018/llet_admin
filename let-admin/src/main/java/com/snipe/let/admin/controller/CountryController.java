package com.snipe.let.admin.controller;

import static com.snipe.let.admin.exception.HttpResponseUtils.prepareSuccessResponse;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.snipe.let.admin.exception.GenericRes;
import com.snipe.let.admin.model.CountryModel;
import com.snipe.let.admin.service.CountryService;

@RestController
@RequestMapping("/v1")

@SuppressWarnings("rawtypes")
public class CountryController {

	@Autowired
	CountryService countryService;

	@RequestMapping(value = "/addCountry", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> addCountry(@RequestBody CountryModel countryModel) throws Exception {
		return prepareSuccessResponse(countryService.addCountry(countryModel));
	}

	@RequestMapping(value = "/countryList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getCountryList() throws Exception {
		return prepareSuccessResponse(countryService.getCountryList());
	}

	@RequestMapping(value = "/countryList/{countryId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getCountryListById(@PathVariable("countryId") long countryID) throws Exception {
		return prepareSuccessResponse(countryService.getCountryListById(countryID));
	}

	@RequestMapping(value = "/updateCountry", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> updateCountry(@RequestBody CountryModel countryModel) throws Exception {
		return prepareSuccessResponse(countryService.updateCountry(countryModel));

	}

	@RequestMapping(value = "/deleteCountry/{countryId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> deleteCountryById(@PathVariable("countryId") long countryId) throws Exception {
		return prepareSuccessResponse(countryService.deleteCountryById(countryId));
	}
}
