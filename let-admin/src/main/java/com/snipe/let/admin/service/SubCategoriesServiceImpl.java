package com.snipe.let.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snipe.let.admin.dao.CartItemRepository;
import com.snipe.let.admin.dao.SubCategoriesDAO;
import com.snipe.let.admin.dao.SubCategoriesImageDAO;
import com.snipe.let.admin.domain.SubCategoriesDomain;
import com.snipe.let.admin.domain.SubCategoriesImageDomain;
import com.snipe.let.admin.mapper.SubCategoriesMapper;
import com.snipe.let.admin.model.SubCategoriesModel;

@Service
public class SubCategoriesServiceImpl implements SubCategoriesService {

	@Autowired
	SubCategoriesDAO subCategoriesDAO;

	@Autowired
	SubCategoriesImageDAO subCategoriesImageDAO;

	@Autowired
	SubCategoriesMapper subCategoriesMapper;

	@Autowired
	CartItemRepository cartItemRepository;

	@Autowired
	RetailerCommonServices retailerCommonServices;

	@Override
	public SubCategoriesDomain addSubCategories(SubCategoriesModel subCategoriesModel) throws Exception {
		SubCategoriesDomain SubcategoriesDomain = new SubCategoriesDomain();
		BeanUtils.copyProperties(subCategoriesModel, SubcategoriesDomain);
		return subCategoriesDAO.addSubCategories(SubcategoriesDomain);
	}

	@Override
	public List<SubCategoriesModel> getSubCategories() throws Exception {
		List<SubCategoriesDomain> subCategoriesDomain = subCategoriesDAO.getSubCategories();
		List<SubCategoriesModel> subCategoriesList = new ArrayList<SubCategoriesModel>();

		for (SubCategoriesDomain subCategoriesDomainDetails : subCategoriesDomain) {
			SubCategoriesModel subCategoriesimageDetails = new SubCategoriesModel();
			BeanUtils.copyProperties(subCategoriesDomainDetails, subCategoriesimageDetails);
			SubCategoriesImageDomain subCategoriesImageDomain = subCategoriesImageDAO
					.getSubCategoriesImageById(subCategoriesDomainDetails.getSubCategoriesId());
			subCategoriesimageDetails.setSubCategoriesImage(subCategoriesImageDomain);
			subCategoriesList.add(subCategoriesimageDetails);
		}

		return subCategoriesList;
	}

	@Override
	public SubCategoriesModel getSubCategoriesById(long subCategoriesId) throws Exception {
		SubCategoriesDomain subCategoriesDomain = subCategoriesDAO.getSubCategoriesById(subCategoriesId);
		SubCategoriesImageDomain subCategoriesImageDomain = subCategoriesImageDAO
				.getSubCategoriesImageById(subCategoriesId);
		// CartItemDomain cartItemDomain =
		// cartItemDAO.getCartItemsByPrdtId(subCategoriesId);
		SubCategoriesModel subCategoriesModel = new SubCategoriesModel();
		BeanUtils.copyProperties(subCategoriesDomain, subCategoriesModel);
		subCategoriesModel.setSubCategoriesImage(subCategoriesImageDomain);
		// subCategoriesModel.setCartItemDomain(cartItemDomain);
		return subCategoriesModel;
	}

	@Override
	public String updateSubCategories(SubCategoriesModel subCategoriesModel) throws Exception {
		SubCategoriesDomain subCategoriesDomain = new SubCategoriesDomain();
		BeanUtils.copyProperties(subCategoriesModel, subCategoriesDomain);
		return subCategoriesDAO.updateSubCategories(subCategoriesDomain);
	}

	@Override
	public String deleteSubCategories(long subCategoriesId) throws Exception {
		return subCategoriesDAO.deleteSubCategories(subCategoriesId);
	}

	@Override
	public List<SubCategoriesModel> getSubCategoriesByCatId(long categoriesId) throws Exception {
		List<SubCategoriesDomain> subCategoriesDomain = subCategoriesDAO.getSubCategoriesByCatId(categoriesId);
		List<SubCategoriesModel> subCategoriesList = new ArrayList<SubCategoriesModel>();

		for (SubCategoriesDomain subCategoriesDomainDetails : subCategoriesDomain) {
			SubCategoriesModel subCategoriesimageDetails = new SubCategoriesModel();
			BeanUtils.copyProperties(subCategoriesDomainDetails, subCategoriesimageDetails);
			SubCategoriesImageDomain subCategoriesImageDomain = subCategoriesImageDAO
					.getSubCategoriesImageById(subCategoriesDomainDetails.getSubCategoriesId());
			// CartItemDomain cartItemDomain =
			// cartItemDAO.getCartItemsByPrdtId(subCategoriesDomainDetails.getSubCategoriesId());
			subCategoriesimageDetails.setSubCategoriesImage(subCategoriesImageDomain);
			// subCategoriesimageDetails.setCartItemDomain(cartItemDomain);
			subCategoriesList.add(subCategoriesimageDetails);
		}
		return subCategoriesList;
	}

	@Override
	public List<SubCategoriesModel> getSubCategoriesByCatTypeId(long categoriesTypeId) throws Exception {
		List<SubCategoriesDomain> subCategoriesDomain = subCategoriesDAO.getSubCategoriesByCatTypeId(categoriesTypeId);
		List<SubCategoriesModel> subCategoriesList = new ArrayList<SubCategoriesModel>();

		for (SubCategoriesDomain subCategoriesDomainDetails : subCategoriesDomain) {
			SubCategoriesModel subCategoriesimageDetails = new SubCategoriesModel();
			BeanUtils.copyProperties(subCategoriesDomainDetails, subCategoriesimageDetails);
			SubCategoriesImageDomain subCategoriesImageDomain = subCategoriesImageDAO
					.getSubCategoriesImageById(subCategoriesDomainDetails.getSubCategoriesId());
			// CartItemDomain cartItemDomain =
			// cartItemDAO.getCartItemsByPrdtId(subCategoriesDomainDetails.getSubCategoriesId());
			subCategoriesimageDetails.setSubCategoriesImage(subCategoriesImageDomain);
			// subCategoriesimageDetails.setCartItemDomain(cartItemDomain);
			subCategoriesList.add(subCategoriesimageDetails);
		}
		return subCategoriesList;
	}

	@Override
	public List<SubCategoriesModel> getCategoryStock(String userId, long categoriesId) throws Exception {
		List<SubCategoriesDomain> subCategoriesDomain = subCategoriesDAO.getSubCategoriesByCatId(categoriesId);
		List<SubCategoriesModel> subCategoriesModel = new ArrayList<SubCategoriesModel>();

		for (SubCategoriesDomain subCategoriesDomainDetails : subCategoriesDomain) {
			SubCategoriesModel subCategoriesM = new SubCategoriesModel();
			BeanUtils.copyProperties(subCategoriesDomainDetails, subCategoriesM);

			SubCategoriesImageDomain subCategoriesImageDomain = subCategoriesImageDAO
					.getSubCategoriesImageById(subCategoriesDomainDetails.getSubCategoriesId());
			subCategoriesM.setSubCategoriesImage(subCategoriesImageDomain);

			subCategoriesM.setStockModel(
					retailerCommonServices.getAvailableStock(userId, subCategoriesDomainDetails.getSubCategoriesId()));

			subCategoriesModel.add(subCategoriesM);
		}
		return subCategoriesModel;

	}

	@Override
	public List<SubCategoriesModel> getCategoryTypeStock(String userId, long categoriesTypeId) throws Exception {
		List<SubCategoriesDomain> subCategoriesDomain = subCategoriesDAO.getSubCategoriesByCatTypeId(categoriesTypeId);
		List<SubCategoriesModel> subCategoriesModel = new ArrayList<SubCategoriesModel>();

		for (SubCategoriesDomain subCategoriesDomainDetails : subCategoriesDomain) {
			SubCategoriesModel subCategoriesM = new SubCategoriesModel();
			BeanUtils.copyProperties(subCategoriesDomainDetails, subCategoriesM);

			SubCategoriesImageDomain subCategoriesImageDomain = subCategoriesImageDAO
					.getSubCategoriesImageById(subCategoriesDomainDetails.getSubCategoriesId());
			subCategoriesM.setSubCategoriesImage(subCategoriesImageDomain);

			subCategoriesM.setStockModel(
					retailerCommonServices.getAvailableStock(userId, subCategoriesDomainDetails.getSubCategoriesId()));

			subCategoriesModel.add(subCategoriesM);
		}
		return subCategoriesModel;
	}
}
