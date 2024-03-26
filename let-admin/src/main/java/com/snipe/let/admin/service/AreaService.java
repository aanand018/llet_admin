package com.snipe.let.admin.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snipe.let.admin.dao.AreaRepository;
import com.snipe.let.admin.dao.CityRepository;
import com.snipe.let.admin.domain.AreaDomain;
import com.snipe.let.admin.domain.CityDomain;

	
	@Service
	public class AreaService {
	    @Autowired
	    private  AreaRepository areaRepository;

	   
	    @Autowired
	     private  CityRepository cityRepository;

	        @Autowired
	        public AreaService(AreaRepository areaRepository, CityRepository cityRepository) {
	            this.areaRepository = areaRepository;
	            this.cityRepository = cityRepository;
	        }

	        public AreaDomain createArea(AreaDomain area) {
//	            // Save the cityDomain entity first if it's not saved yet
//	            CityDomain cityDomain = area.getCityDomain();
//	            if (cityDomain != null && cityDomain.getCityId() == 0) {  // Assuming 0 is an indicator of a new unsaved city
//	                cityDomain = cityRepository.save(cityDomain);
//	                area.setCityDomain(cityDomain);  // Update the area's cityDomain with the saved cityDomain
//	            }

	            return areaRepository.save(area);
	        }
	    
	    public AreaDomain getAreaById(int areaId) {
	        return areaRepository.findById(areaId).orElse(null);
	    }

	    public List<AreaDomain> getAllAreas() {
	        return areaRepository.findAll();
	    }
	    
	    public AreaDomain updateArea(AreaDomain area) {
	    	   AreaDomain existingArea = areaRepository.findById(area.getAreaId()).orElse(null);
	    	   existingArea.setAreaName(area.getAreaName());
	    	   existingArea.setLattitude(area.getLattitude());
	    	   existingArea.setLongittude(area.getLongittude());
	    	   existingArea.setPinCode(area.getPinCode());
	    	
	          return areaRepository.save(existingArea);
	      }
	    
	    public String deleteArea(int areaId) {
	        areaRepository.deleteById(areaId);
			return "area removed"+ areaId;
	    }
	}


