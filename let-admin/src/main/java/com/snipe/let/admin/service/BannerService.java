package com.snipe.let.admin.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.snipe.let.admin.model.BannerModel;



public interface BannerService {

	public String saveBanner(MultipartFile file) throws IOException;
	
	public List<BannerModel> getBanners() throws Exception;
	
	public String deleteBanner(long id) throws Exception;
}
