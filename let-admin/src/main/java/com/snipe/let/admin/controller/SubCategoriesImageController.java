package com.snipe.let.admin.controller;

import static com.snipe.let.admin.exception.HttpResponseUtils.prepareSuccessResponse;

import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.snipe.let.admin.exception.GenericRes;
import com.snipe.let.admin.service.SubCategoriesImageService;

@RestController
@RequestMapping("/v1")
@SuppressWarnings("rawtypes")
public class SubCategoriesImageController {

	@Autowired
	SubCategoriesImageService subCategoriesImageService;

	@PostMapping(value = "/subCategoriesImage")
	@ResponseBody
	public ResponseEntity<GenericRes> addSubCategoriesImage(@RequestParam("file") MultipartFile file,
			@RequestParam("subCategoriesId") Integer subCategoriesId, RedirectAttributes redirectAttributes) throws Exception {
		return prepareSuccessResponse(subCategoriesImageService.addSubCategoriesImage(subCategoriesId, file));
	}
	
	@RequestMapping(value = "/subCategoriesImage/{subCategoriesId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getSubCategoriesImageById(@PathVariable("subCategoriesId") long subCategoriesId) throws Exception {
		return prepareSuccessResponse(subCategoriesImageService.getSubCategoriesImageById(subCategoriesId));
	}

}
