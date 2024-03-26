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
import com.snipe.let.admin.model.CategoriesTypeModel;
import com.snipe.let.admin.service.CategoriesTypeService;

@RestController
@RequestMapping("/v1")

@SuppressWarnings("rawtypes")
public class CategoriesTypeController {

	@Autowired
	CategoriesTypeService categoriesTypeService;

	@RequestMapping(value = "/AddCategoriesType", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> addCategoriesType(@RequestBody CategoriesTypeModel categoriesTypeModel)
			throws Exception {
		return prepareSuccessResponse(categoriesTypeService.addCategoriesType(categoriesTypeModel));
	}

	@RequestMapping(value = "/categoriesTypeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getCategoriesType() throws Exception {
		return prepareSuccessResponse(categoriesTypeService.getCategoriesType());
	}

	@RequestMapping(value = "/CategoriesType/{CategoriesTypeID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getCategoriesTypeById(@PathVariable("CategoriesTypeID") long CategoriesTypeID)
			throws Exception {
		return prepareSuccessResponse(categoriesTypeService.getCategoriesTypeById(CategoriesTypeID));
	}

	@RequestMapping(value = "/updateCategoriesType", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> updateCategoriesType(@RequestBody CategoriesTypeModel categoriesTypeModel)
			throws Exception {
		return prepareSuccessResponse(categoriesTypeService.updateCategoriesType(categoriesTypeModel));
	}

	@RequestMapping(value = "/deleteCategoriesType/{catoriesegTypeId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> deleteCategoriesType(@PathVariable("catoriesegTypeId") long catoriesegTypeId)
			throws Exception {
		return prepareSuccessResponse(categoriesTypeService.deleteCategoriesType(catoriesegTypeId));
	}

}
