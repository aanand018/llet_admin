package com.snipe.let.admin.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.snipe.let.admin.model.SubCategoriesImageModel;

public interface SubCategoriesImageService {

	public String addSubCategoriesImage(long subCategoriesId, MultipartFile file) throws Exception;

	public SubCategoriesImageModel getSubCategoriesImageById(long subCategoriesId) throws Exception;

	public List<SubCategoriesImageModel> getSubCategoriesImagesbysubCategoriesId(long subCategoriesId) throws Exception;

	public List<SubCategoriesImageModel> getSubCategoriesImageList() throws Exception;

}
