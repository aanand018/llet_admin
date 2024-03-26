package com.snipe.let.admin.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snipe.let.admin.domain.CatalogueDomain;
import com.snipe.let.admin.domain.CityDomain;
import com.snipe.let.admin.model.CatalogueModel;

public interface CatalogueDAO {

	
	
	public List<CatalogueDomain> catelogueInfonWHorRL(long stateId, long cityId, LocalDateTime fromDate, LocalDateTime toDate,String storeType,String catalogueType) throws Exception;

	public List<CatalogueDomain> catelogueInfonWHorRL(long stateId, long cityId, LocalDateTime fromDate, LocalDateTime toDate ) throws Exception;

	public void addCatalogueDomain(CatalogueDomain catDomain);
	
	
	
}
