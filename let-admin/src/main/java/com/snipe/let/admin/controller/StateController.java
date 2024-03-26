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
import com.snipe.let.admin.model.StateModel;
import com.snipe.let.admin.service.StateService;

@RestController
@RequestMapping("/v1")

@SuppressWarnings("rawtypes")
public class StateController {

	@Autowired
	StateService stateService;

	@RequestMapping(value = "/addState", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> addState(@RequestBody StateModel stateModel) throws Exception {
		return prepareSuccessResponse(stateService.addState(stateModel));

	}

	@RequestMapping(value = "/stateList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getStateList() throws Exception {
		return prepareSuccessResponse(stateService.getStateList());
	}

	@RequestMapping(value = "/state/Details/{stateId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getStateListById(@PathVariable("stateId") long stateId) throws Exception {
		return prepareSuccessResponse(stateService.getStateListById(stateId));
	}

	@RequestMapping(value = "/state/List/{countryId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getStatedetails(@PathVariable("countryId") long countryId) throws Exception {
		return prepareSuccessResponse(stateService.getStatedetails(countryId));
	}

	@RequestMapping(value = "/updateState", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> updateState(@RequestBody StateModel stateModel) throws Exception {
		return prepareSuccessResponse(stateService.updateState(stateModel));

	}

	@RequestMapping(value = "/deleteState/{stateId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> deleteStateById(@PathVariable("stateId") long stateId) throws Exception {
		return prepareSuccessResponse(stateService.deleteStateById(stateId));
	}

	@RequestMapping(value = "/state/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> stateCount() throws Exception {
		return prepareSuccessResponse(stateService.stateCount());
	}

}
