package com.snipe.let.admin.service;



import java.time.LocalDateTime;

import java.util.List;


import com.snipe.let.admin.domain.CatalogueDomain;
import com.snipe.let.admin.model.CatalogueModel;

public interface CatalogueService {

	public List<CatalogueModel> catelogueInfonWHorRL(long stateId, long cityId, LocalDateTime fromDate, LocalDateTime toDate,String storeType,String catalogueType) throws Exception;

	public List<CatalogueModel> catelogueInfonWHorRL(long stateId, long cityId, LocalDateTime fromDate, LocalDateTime toDate) throws Exception;

	public CatalogueDomain generateId(CatalogueModel caDomain);
	
	
}













































/*

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snipe.let.admin.dao.CatalogueRepo;
import com.snipe.let.admin.dao.CityRepository;
import com.snipe.let.admin.dao.StateRepository;
import com.snipe.let.admin.domain.CatalogueDomain;
import com.snipe.let.admin.domain.CityDomain;
import com.snipe.let.admin.domain.StateDomain;
import com.snipe.let.admin.model.CatalogueModel;

@Service
public class CatalogueService {



	@Autowired
	StateRepository stateRepository;

	@Autowired
	CityRepository cityRepository;

	CatalogueService catalogueService;

	private final CatalogueRepo catalogueRepository;


	@Autowired
	public CatalogueService(CatalogueRepo catalogueRepository) {
		this.catalogueRepository = catalogueRepository;
	}


	public  List<CatalogueDomain> getSortedProducts() {
		return catalogueRepository.findAllByOrderByCatalogueIdDesc();
	}


	public CatalogueDomain getProduct(String catId) {
		return catalogueRepository.findByCatalogueId(catId);
	}



	public  String generateAnotherId(String state,String city,String formattedDate,Long counts,String stockType,String catalogueType) 
	{

		String catId="";
		if(stockType.equals("RETAILER")) {
			if(catalogueType.equals("GENERAL")) {
				catId= state+ "-" + city + "-" + "RL" + "-" + "GN" + "-" + formattedDate+ "-" + String.format("%02d", counts);
			}
			else {
				catId= state+ "-" + city + "-" + "RL" + "-" + "SP" +"-"+formattedDate+ "-" + String.format("%02d",counts);
			}
		}
		else{
			if(catalogueType.equals("GENERAL")) {
				catId= state+ "-" + city + "-" + "WH"+"-" + "GN" +"-" + formattedDate+ "-" + String.format("%02d", counts);
			}
			else {
				catId= state+ "-" + city + "-"+"WS"+"-"+"SP" + "-"+formattedDate+ "-" + String.format("%02d", counts);
			}
		}
		try {
			CatalogueDomain c= catalogueRepository.findByCatalogueId(catId);
			System.out.println(c.getCatalogueId());
			while(c!=null) {
				catId=  generateAnotherId(state,city,formattedDate,counts+1,stockType,catalogueType);
				c= catalogueRepository.findByCatalogueId(catId);
			}
		}catch (Exception e) {
}

		return catId;

	}




	public void generateId(CatalogueModel caDomain) {


		// for initializing data
		CatalogueDomain catDomain=new CatalogueDomain();
		catDomain.setCatalogueName(caDomain.getCatalogueName());
		catDomain.setState(caDomain.getState());
		catDomain.setCity(caDomain.getCity());
		catDomain.setCatalogueType(caDomain.getCatalogueType());
		catDomain.setCatalogueStatus(caDomain.getCatalogueStatus());
		catDomain.setProductStatus(caDomain.getProductStatus());
		catDomain.setDiscount(caDomain.getDiscount());
		catDomain.setFromDate(caDomain.getFromDate());	
		catDomain.setToDate(caDomain.getToDate());
		catDomain.setProductId(caDomain.getProductId());
		catDomain.setUnitPrice(caDomain.getUnitPrice());
		catDomain.setStoreType(caDomain.getStoreType());


		// Extract month and year  .........
		int month = caDomain.getFromDate().getMonthValue();
		int year = caDomain.getFromDate().getYear() % 100; // Get last two digits of the year

		// Format the month and year ..........
		String formattedDate = String.format("%02d%02d", month, year);  //1824


		//for getting STATE AND CITY  name  ...........
		StateDomain state = stateRepository.findById(   catDomain.getState().getStateId())
				.orElseThrow(() -> new EntityNotFoundException("State not found with id.."));
		CityDomain city= cityRepository.findById(catDomain.getCity().getCityId())
				.orElseThrow(() -> new EntityNotFoundException("city not found with id.."));

		//for getting stateShortName  ..........
		String stateShortName = state.getShortName(); 
		String cityShortName = city.getShortName(); 

		//getting count of records from catalogueDomain  ...........
		Long count =catalogueRepository.count();
		//	checking stockTypeType  here whether it is from RETAILER OR WAREHOUSE   ...........
		String stockType =caDomain.getStoreType().toUpperCase();
		//checking catalogueType here it is SPECIAL OR GENERAL  ......
		String catalogueType=caDomain.getCatalogueType().toUpperCase();


		String catId="";




		if(stockType.equals("RETAILER")) {
			if(catalogueType.equals("GENERAL")) {
				catId= stateShortName + "-" + cityShortName + "-" + "RL" + "-" + "GN" + "-" + formattedDate+ "-" + String.format("%02d", count);
			}
			else {
				catId=stateShortName + "-" + cityShortName + "-" + "RL" + "-" + "SP" +"-"+formattedDate+ "-" + String.format("%02d",count);
			}
		}
		else{
			if(catalogueType.equals("GENERAL")) {
				catId= stateShortName+ "-" + cityShortName + "-" + "WH"+"-" + "GN" +"-" + formattedDate+ "-" + String.format("%02d", count);
			}
			else {
				catId= stateShortName+ "-" + cityShortName + "-"+"WS"+"-"+"SP" + "-"+formattedDate+ "-" + String.format("%02d", count);
			}
		}



		try {
			CatalogueDomain c= catalogueRepository.findByCatalogueId(catId);
			System.out.println(c.getCatalogueId());
			while(c!=null) {
				catId=  generateAnotherId(stateShortName,cityShortName,formattedDate,count+1,stockType,catalogueType);
				c= catalogueRepository.findByCatalogueId(catId);
			}
		}catch (Exception e) {
		}
		catDomain.setCatalogueId(catId);
		catalogueRepository.save(catDomain);





	}












}
*/




