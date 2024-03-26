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
import com.snipe.let.admin.model.CategoriesModel;
import com.snipe.let.admin.service.CategoriesService;

@RestController
@RequestMapping("/v1")

@SuppressWarnings("rawtypes")
public class CategoriesController {

	@Autowired
	CategoriesService categoriesService;

	@RequestMapping(value = "/addCategories", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> addCategories(@RequestBody CategoriesModel categoriesModel) throws Exception {
		return prepareSuccessResponse(categoriesService.addCategories(categoriesModel));
	}

	@RequestMapping(value = "/categoriesList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getCategories() throws Exception {
		return prepareSuccessResponse(categoriesService.getCategories());
	}

	@RequestMapping(value = "/CategoriesList/{CategoriesID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getCategoriesById(@PathVariable("CategoriesID") long CategoriesID)
			throws Exception {
		return prepareSuccessResponse(categoriesService.getCategoriesById(CategoriesID));
	}

	@RequestMapping(value = "/updateCategories", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> updateCategories(@RequestBody CategoriesModel categoriesModel) throws Exception {
		return prepareSuccessResponse(categoriesService.updateCategories(categoriesModel));
	}

	@RequestMapping(value = "/deleteCategories/{catoriesegId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> deleteCategories(@PathVariable("catoriesegId") long catoriesegId)
			throws Exception {
		return prepareSuccessResponse(categoriesService.deleteCategories(catoriesegId));
	}

	@RequestMapping(value = "/CategoriesList/CategoriesTypeId/{categoriesTypeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getCategoriesByTypeId(@PathVariable("categoriesTypeId") long categoriesTypeId)
			throws Exception {
		return prepareSuccessResponse(categoriesService.getCategoriesByTypeId(categoriesTypeId));
	}

}
