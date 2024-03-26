package com.snipe.let.admin.service;

import java.time.LocalDate;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snipe.let.admin.dao.CatalogueDAO;
import com.snipe.let.admin.dao.CatalogueRepo;
import com.snipe.let.admin.dao.CityDAOImpl;
import com.snipe.let.admin.dao.CityRepository;
import com.snipe.let.admin.dao.CategoriesDAOImpl;
import com.snipe.let.admin.dao.CityDAOImpl;
import com.snipe.let.admin.dao.ProductDao;
import com.snipe.let.admin.dao.StateDAOImpl;
import com.snipe.let.admin.dao.StateRepository;
import com.snipe.let.admin.domain.CatalogueDomain;
import com.snipe.let.admin.domain.CategoriesDomain;
import com.snipe.let.admin.domain.CityDomain;
import com.snipe.let.admin.domain.ProductDomain;
import com.snipe.let.admin.domain.StateDomain;
import com.snipe.let.admin.domain.SubCategoriesDomain;
import com.snipe.let.admin.model.CatalogueModel;
import com.snipe.let.admin.model.SubCategoriesModel;

@Service
public class CatalogueServiceImpl implements CatalogueService {

	private static final Logger logger = LoggerFactory.getLogger(CatalogueServiceImpl.class);

	@Autowired
	CatalogueDAO catalogueDAO;

	@Autowired
	CatalogueRepo catalogueRepository;

	@Autowired
	StateRepository stateRepository;

	@Autowired
	CityRepository cityRepository;



	@Autowired
	CityDAOImpl cityDAOImpl;

	@Autowired
	StateDAOImpl stateDAOImpl;
	
	@Autowired
	CategoriesDAOImpl categoriesDAOImpl;
	
	@Autowired
	ProductDao productDao;

	@Override
	public List<CatalogueModel> catelogueInfonWHorRL(long stateId, long cityId, LocalDateTime fromDate,
			LocalDateTime toDate, String storeType, String catalogueType) throws Exception {

		List<CatalogueDomain> catalogueDomain = catalogueDAO.catelogueInfonWHorRL(stateId, cityId, fromDate, toDate,
				storeType, catalogueType);
		CityDomain cityDomain = cityDAOImpl.getCityListById(cityId);
		StateDomain stateDomain = stateDAOImpl.getStateListById(stateId);

		List<CatalogueModel> catalogueModel = new ArrayList<CatalogueModel>();

		for (CatalogueDomain catDomain : catalogueDomain) {

			CatalogueModel catModel = new CatalogueModel();

			catModel.setCatalogueId(catDomain.getCatalogueId());
			catModel.setCatalogueName(catDomain.getCatalogueName());
			catModel.setCategoriesId(catDomain.getCategoriesId());
			
			
			CategoriesDomain categoriesDomain = categoriesDAOImpl.getCategoriesById(catDomain.getCategoriesId());
			catModel.setCategoriesName(categoriesDomain.getCategoriesName());
	
			catModel.setStateId(catDomain.getStateId());
			catModel.setStateName(stateDomain.getStateName());
			catModel.setCityId(catDomain.getCityId());
			catModel.setCityName(cityDomain.getCityName());
			catModel.setFromDate(catDomain.getFromDate());
			catModel.setToDate(catDomain.getToDate());
			catModel.setCatalogueType(catDomain.getCatalogueType());
			catModel.setProductId(catDomain.getProductId());// we want product name
			catModel.setUnitPrice(catDomain.getUnitPrice());
			catModel.setCatalogueType(catDomain.getCatalogueType());
			catModel.setProductId(catDomain.getProductId());
			
		       
	        Optional<ProductDomain> productDomain = productDao.findByProductId(catDomain.getProductId());

	        if (productDomain.isPresent()) {
	            catModel.setProductName(productDomain.get().getProductName());
	     
	        } else {
	            System.out.println("Product with ID " + catDomain.getProductId() + " not found.");
	        }
	        
           	catModel.setUnitPrice(catDomain.getUnitPrice());
			catModel.setDiscountPerctg(catDomain.getDiscountPerctg());
			catModel.setCatalogueStatus(catDomain.getCatalogueStatus());
			catModel.setProductStatus(catDomain.getProductStatus());
			catModel.setStoreType(catDomain.getStoreType());

			catalogueModel.add(catModel);
		}
		return catalogueModel;

	}

	@Override
	public List<CatalogueModel> catelogueInfonWHorRL(long stateId, long cityId, LocalDateTime fromDate,
			LocalDateTime toDate) throws Exception {

		List<CatalogueDomain> catalogueDomain = catalogueDAO.catelogueInfonWHorRL(stateId, cityId, fromDate, toDate);
		CityDomain cityDomain = cityDAOImpl.getCityListById(cityId);
		StateDomain stateDomain = stateDAOImpl.getStateListById(stateId);

		List<CatalogueModel> catalogueModel = new ArrayList<CatalogueModel>();

		for (CatalogueDomain catDomain : catalogueDomain) {

			CatalogueModel catModel = new CatalogueModel();

			catModel.setCatalogueId(catDomain.getCatalogueId());
			catModel.setCatalogueName(catDomain.getCatalogueName());
			catModel.setCategoriesId(catDomain.getCategoriesId());
			
			
			CategoriesDomain categoriesDomain = categoriesDAOImpl.getCategoriesById(catDomain.getCategoriesId());
			catModel.setCategoriesName(categoriesDomain.getCategoriesName());
	
			catModel.setStateId(catDomain.getStateId());
			catModel.setStateName(stateDomain.getStateName());
			catModel.setCityId(catDomain.getCityId());
			catModel.setCityName(cityDomain.getCityName());
			catModel.setFromDate(catDomain.getFromDate());
			catModel.setToDate(catDomain.getToDate());
			catModel.setCatalogueType(catDomain.getCatalogueType());
			catModel.setProductId(catDomain.getProductId());// we want product name
			
		       
	        Optional<ProductDomain> productDomain = productDao.findByProductId(catDomain.getProductId());

	        if (productDomain.isPresent()) {
	            catModel.setProductName(productDomain.get().getProductName());
	        } else {
	            System.out.println("Product with ID " + catDomain.getProductId() + " not found.");
	        }
	        
           	catModel.setUnitPrice(catDomain.getUnitPrice());
			catModel.setDiscountPerctg(catDomain.getDiscountPerctg());
			catModel.setCatalogueStatus(catDomain.getCatalogueStatus());
			catModel.setProductStatus(catDomain.getProductStatus());
			catModel.setStoreType(catDomain.getStoreType());

			catalogueModel.add(catModel);

		}
		return catalogueModel;


	}


	
	@Override
	public CatalogueDomain generateId(CatalogueModel caModel) {

		

		CatalogueDomain catDomain=new CatalogueDomain();
		
		LocalDate date=LocalDate.now();

		catDomain.setCategoriesId(caModel.getCategoriesId());
		catDomain.setCatalogueStatus(caModel.isCatalogueStatus());
		catDomain.setProductStatus(caModel.isProductStatus());
		catDomain.setProductId(caModel.getProductId());
		catDomain.setCatalogueName(caModel.getCatalogueName());
		catDomain.setCatalogueStatus(caModel.isCatalogueStatus());
		catDomain.setCatalogueType(caModel.getCatalogueType());
		catDomain.setCityId(caModel.getCityId());
		catDomain.setStateId(caModel.getStateId());
		//catDomain.setFromDate(caModel.getFromDate());
		catDomain.setFromDate(date);
		catDomain.setToDate(caModel.getToDate());
		catDomain.setDiscountPerctg(caModel.getDiscountPerctg());
		catDomain.setUnitPrice(caModel.getUnitPrice());
		catDomain.setStoreType(caModel.getStoreType());

         
		System.out.println(catDomain.getStateId());
		System.out.println(catDomain.getCityId());

		//for getting STATE AND CITY  name  ...........
		StateDomain state = stateRepository.findById(catDomain.getStateId())
				.orElseThrow(() -> new EntityNotFoundException("State not found with id.."));
		CityDomain city= cityRepository.findById(catDomain.getCityId())
				.orElseThrow(() -> new EntityNotFoundException("city not found with id.."));

		//for getting stateShortName  ..........
		String stateShortName = state.getShortName(); 
		String cityShortName = city.getShortName(); 
		
		//System.out.println(stateShortName+"-"+cityShortName);

		// Extract month and year  .........
		int month = catDomain.getFromDate().getMonthValue();
		int year = catDomain.getFromDate().getYear() % 100; // Get last two digits of the year


		String formattedDate = String.format("%02d%02d", month, year);  //1824
		//System.out.println(formattedDate);

		//getting count of records from catalogueDomain  ...........
		long count =catalogueRepository.count()+1;
		//System.out.println(count+" counts");
		//	checking stockTypeType  here whether it is from RETAILER OR WAREHOUSE   ...........
		String stockType =catDomain.getStoreType().toUpperCase();
		//checking catalogueType here it is SPECIAL OR GENERAL  ......
		String catalogueType=catDomain.getCatalogueType().toUpperCase();

		String catId="";


		if(stockType.equals("RL")) {
			if(catalogueType.equals("GN")) {
				catId= stateShortName + "-" + cityShortName + "-" + "RL" + "-" + "GN" + "-" + formattedDate+ "-" + String.format("%02d", count);
			}
			else {
				catId=stateShortName + "-" + cityShortName + "-" + "RL" + "-" + "SP" +"-"+formattedDate+ "-" + String.format("%02d",count);
			}
		}
		else{
			if(catalogueType.equals("GN")) {
				catId= stateShortName+ "-" + cityShortName + "-" + "WH"+"-" + "GN" +"-" + formattedDate+ "-" + String.format("%02d", count);
			}
			else {
				catId= stateShortName+ "-" + cityShortName + "-"+"WS"+"-"+"SP" + "-"+formattedDate+ "-" + String.format("%02d", count);
			}
		}

		
		
		catDomain.setCatalogueId(catId);
		
	//	System.out.println(catDomain.getCatalogueId());
		
		//catalogueRepository.save(catDomain); 
		
		
		catalogueDAO.addCatalogueDomain(catDomain);
		
		
		return catDomain;
	}
	

}	
