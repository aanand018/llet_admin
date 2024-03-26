package com.snipe.let.admin.controller;

import static com.snipe.let.admin.exception.HttpResponseUtils.prepareSuccessResponse;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.snipe.let.admin.exception.GenericRes;
import com.snipe.let.admin.model.EmployeeModel;
import com.snipe.let.admin.service.EmployeeService;
@RestController
@RequestMapping("/v1")

@SuppressWarnings("rawtypes")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> addEmployee(@RequestBody EmployeeModel employeeModel) throws Exception {
		return prepareSuccessResponse(employeeService.addEmployee(employeeModel));
	}

}
