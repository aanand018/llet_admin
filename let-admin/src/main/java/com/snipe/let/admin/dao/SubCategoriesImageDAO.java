package com.snipe.let.admin.dao;

import java.util.List;

import com.snipe.let.admin.domain.SubCategoriesImageDomain;

public interface SubCategoriesImageDAO {
	
    public String addSubCategoriesImage(SubCategoriesImageDomain subCategoriesImageDomain) throws Exception;
	
	public SubCategoriesImageDomain getSubCategoriesImageById(long subCategoriesId) throws Exception;
	
	public List<SubCategoriesImageDomain> getSubCategoriesImagesbysubCategoriesId(long subCategoriesId) throws Exception;
	
	public List<SubCategoriesImageDomain> getSubCategoriesImageList() throws Exception;

}
