package com.snipe.let.admin.service;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.snipe.let.admin.dao.BannerRepository;

import com.snipe.let.admin.domain.BannerDomain;
import com.snipe.let.admin.exception.LetRestException.FILE_UPLOAD_FAILED;
import com.snipe.let.admin.mapper.BannerMapper;
import com.snipe.let.admin.model.BannerModel;



@Service
public class BannerServiceImpl implements BannerService{

    @Autowired
    BannerRepository   bannerRepository; 
    
    @Autowired
	BannerMapper bannerMapper;
    
	@Override
	public String saveBanner(MultipartFile file) throws IOException {
		
		if (file.isEmpty())
			throw new FILE_UPLOAD_FAILED("Please select a file to upload");
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    BannerDomain FileDB = new BannerDomain(fileName, file.getContentType(), file.getBytes());
	    
	    bannerRepository.save(FileDB); 
		return " Banner Saved ";
	}
	
	
	@Override
	public List<BannerModel> getBanners() throws Exception {
		List<BannerDomain> bannerDomain = bannerRepository.findAll();
		return bannerMapper.entityList(bannerDomain);
	}
	
	@Override
	public String deleteBanner(long id) throws Exception{
		bannerRepository.deleteById(id);
		return "Banner Deleted Succesfully";
	}
	
	
	
	

}
