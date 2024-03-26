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
import com.snipe.let.admin.model.CityModel;
import com.snipe.let.admin.service.CityService;

@RestController
@RequestMapping("/v1")

@SuppressWarnings("rawtypes")
public class CityController {

	@Autowired
	CityService cityService;

	@RequestMapping(value = "/city", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> addCity(@RequestBody CityModel cityModel) throws Exception {
		return prepareSuccessResponse(cityService.addCity(cityModel));
	}

	@RequestMapping(value = "/cityList", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<GenericRes> getCityList() throws Exception {
		return prepareSuccessResponse(cityService.getCityList());
	}

	@RequestMapping(value = "/city/list/{stateId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getCityList(@PathVariable("stateId") long stateId) throws Exception {
		return prepareSuccessResponse(cityService.getCityList(stateId));
	}

	@RequestMapping(value = "/cityList/{cityID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getCityListById(@PathVariable("cityID") long cityID) throws Exception {
		return prepareSuccessResponse(cityService.getCityListById(cityID));
	}

	@RequestMapping(value = "/updateCity", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> updateCity(@RequestBody CityModel cityModel) throws Exception {
		return prepareSuccessResponse(cityService.updateCity(cityModel));

	}

	@RequestMapping(value = "/deleteCity/{cityId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> deleteCityById(@PathVariable("cityId") long cityId) throws Exception {
		return prepareSuccessResponse(cityService.deleteCityById(cityId));
	}
}
