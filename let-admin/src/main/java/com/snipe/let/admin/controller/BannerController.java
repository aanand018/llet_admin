package com.snipe.let.admin.controller;

import static com.snipe.let.admin.exception.HttpResponseUtils.prepareSuccessResponse;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.snipe.let.admin.exception.GenericRes;
import com.snipe.let.admin.service.BannerService;

@RestController
@RequestMapping("/v1")
public class BannerController {
	
	@Autowired
	BannerService   bannerService;
	
	@PostMapping("/saveBanner")
	public ResponseEntity<GenericRes> saveBanner(@RequestParam("file") MultipartFile file) throws Exception {
		return prepareSuccessResponse(bannerService.saveBanner(file));
	}
	
    @GetMapping("/getBanners")
	public ResponseEntity<GenericRes> getBanners() throws Exception {
		return prepareSuccessResponse(bannerService.getBanners());
	}
    
    @DeleteMapping("/deleteBanner/{id}")
    public ResponseEntity<GenericRes> deleteBanner(@PathVariable("id") long id) throws Exception 
    {
    	return prepareSuccessResponse(bannerService.deleteBanner(id));	
    }

}
