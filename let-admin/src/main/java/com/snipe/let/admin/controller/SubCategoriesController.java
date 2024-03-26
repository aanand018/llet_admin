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
import com.snipe.let.admin.model.SubCategoriesModel;
import com.snipe.let.admin.service.SubCategoriesService;

@RestController
@RequestMapping("/v1")

@SuppressWarnings("rawtypes")
public class SubCategoriesController {

	@Autowired
	SubCategoriesService subCategoriesService;

	@RequestMapping(value = "/subCategories", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> addSubCategories(@RequestBody SubCategoriesModel subCategoriesModel)
			throws Exception {
		return prepareSuccessResponse(subCategoriesService.addSubCategories(subCategoriesModel));
	}

	@RequestMapping(value = "/subCategoriesList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getSubCategories() throws Exception {
		return prepareSuccessResponse(subCategoriesService.getSubCategories());
	}

	@RequestMapping(value = "/subCategoriesList/{subCategoriesID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getSubCategoriesById(@PathVariable("subCategoriesID") long subCategoriesID)
			throws Exception {
		return prepareSuccessResponse(subCategoriesService.getSubCategoriesById(subCategoriesID));
	}

	@RequestMapping(value = "/updateSubCategories", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> updateSubCategories(@RequestBody SubCategoriesModel subCategoriesModel)
			throws Exception {
		return prepareSuccessResponse(subCategoriesService.updateSubCategories(subCategoriesModel));
	}

	@RequestMapping(value = "/deleteSubCategories/{subCategoriesID}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> deleteSubCategories(@PathVariable("subCategoriesID") long subCategoriesID)
			throws Exception {
		return prepareSuccessResponse(subCategoriesService.deleteSubCategories(subCategoriesID));
	}

	@RequestMapping(value = "/subCategoriesList/CategoriesId/{categoriesID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getSubCategoriesByCatId(@PathVariable("categoriesID") long categoriesID)
			throws Exception {
		return prepareSuccessResponse(subCategoriesService.getSubCategoriesByCatId(categoriesID));
	}

	@RequestMapping(value = "/subCategoriesList/CategoriesTypeId/{categoriesTypeID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getSubCategoriesByCatTypeId(
			@PathVariable("categoriesTypeID") long categoriesTypeID) throws Exception {
		return prepareSuccessResponse(subCategoriesService.getSubCategoriesByCatTypeId(categoriesTypeID));
	}

	@RequestMapping(value = "/user/category/stock/{userId}/{categoryId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getCategoryStock(@PathVariable("userId") String userId,
			@PathVariable("categoryId") long categoryId) throws Exception {
		return prepareSuccessResponse(subCategoriesService.getCategoryStock(userId, categoryId));
	}

	@RequestMapping(value = "/user/category/type/stock/{userId}/{categoriesTypeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getCategoryTypeStock(@PathVariable("userId") String userId,
			@PathVariable("categoriesTypeId") long categoriesTypeId) throws Exception {
		return prepareSuccessResponse(subCategoriesService.getCategoryTypeStock(userId, categoriesTypeId));
	}
}
