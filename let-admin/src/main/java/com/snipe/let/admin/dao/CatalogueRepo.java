package com.snipe.let.admin.dao;



import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.snipe.let.admin.domain.CatalogueDomain;


public interface CatalogueRepo extends JpaRepository<CatalogueDomain, String> {

	CatalogueDomain findByCatalogueId(String catId);

	List<CatalogueDomain> findAllByOrderByCatalogueIdDesc();


	List<CatalogueDomain> findByStateIdAndCityId(long stateId, long cityId);

	List<CatalogueDomain> findByStateIdAndCityIdAndStoreTypeAndCatalogueType(long stateId, long cityId,
			String storeType, String catalogueType);


	
	

}
