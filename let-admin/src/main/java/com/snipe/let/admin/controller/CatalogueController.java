package com.snipe.let.admin.controller;



import static com.snipe.let.admin.exception.HttpResponseUtils.prepareSuccessResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;



import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.snipe.let.admin.dao.CatalogueRepo;
import com.snipe.let.admin.dao.CityRepository;
import com.snipe.let.admin.dao.StateRepository;
import com.snipe.let.admin.domain.CatalogueDomain;
import com.snipe.let.admin.exception.GenericRes;
import com.snipe.let.admin.model.CatalogueModel;
import com.snipe.let.admin.service.CatalogueService;

import ch.qos.logback.classic.Logger;


@RestController
@RequestMapping("/v1")
public class CatalogueController {


	@Autowired
	CatalogueRepo cRepo;

	@Autowired
	StateRepository stateRepository;

	@Autowired
	CityRepository cityRepository;

	@Autowired
	CatalogueService catalogueService;


	@PostMapping(value = "/generateId", consumes = MediaType.APPLICATION_JSON , produces =MediaType.APPLICATION_JSON )
	public ResponseEntity<?> catalogpost(@RequestBody CatalogueModel caDomain){	
	
		catalogueRepo.save(catalogueService. generateId(caDomain));
	
	
	return prepareSuccessResponse(ResponseEntity.status(HttpStatus.OK).body("id genreated......."));


	}
	
	
	
	@GetMapping("/catelogue/{stateId}/{cityId}")
	public List<CatalogueDomain> catalogeGet(@PathVariable long stateId,
            @PathVariable long cityId
            ){
		//return catalogueRepo.findABy();
		
		
	return catalogueRepo.findByStateIdAndCityId(stateId,cityId);
	}
	
	
	
	
	@GetMapping("/{stateId}/{cityId}/{storeType}/{catalogueType}")
	public List<CatalogueDomain> catalogeGet(@PathVariable long stateId,
	        @PathVariable long cityId,
	        @PathVariable String storeType,
	        @PathVariable String catalogueType) {
	    return catalogueRepo.findByStateIdAndCityIdAndStoreTypeAndCatalogueType(stateId, cityId, storeType, catalogueType);
	}

	
	
	
	
	
//	@Autowired
//	CatalogueService catalogueService;
	
	@Autowired
	CatalogueRepo catalogueRepo;
	
	@GetMapping(value="/catelogue/{stateId}/{cityId}/{fromDate}/{toDate}/{storeType}/{catalogueType}",produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<?> catelogueInfonWHorRL(@PathVariable("stateId") long stateId,@PathVariable("cityId") long cityId,
			@PathVariable("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")  LocalDateTime fromDate,
			@PathVariable("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")  LocalDateTime toDate,
			@PathVariable("storeType") String storeType,@PathVariable("catalogueType") String catalogueType) throws Exception{
		
		return prepareSuccessResponse(catalogueService.catelogueInfonWHorRL(stateId,cityId,fromDate,toDate,storeType,catalogueType));
	}
	
	@GetMapping(value="/catelogue/{stateId}/{cityId}/{fromDate}/{toDate}",produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<?> catelogueInfonWHorRL(@PathVariable("stateId") long stateId,@PathVariable("cityId") long cityId,
			@PathVariable("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")  LocalDateTime fromDate,
			@PathVariable("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")  LocalDateTime toDate
			) throws Exception{
		
		
		return prepareSuccessResponse(catalogueService.catelogueInfonWHorRL(stateId,cityId,fromDate,toDate));
	}

	

	
	
	







}






