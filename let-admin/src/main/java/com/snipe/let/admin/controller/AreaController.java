package com.snipe.let.admin.controller;


	
	




	import java.util.List;



	import org.springframework.beans.factory.annotation.Autowired;

	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.snipe.let.admin.domain.AreaDomain;

	import com.snipe.let.admin.service.AreaService;

	@RestController
	@RequestMapping("/v1")
	public class AreaController {
		
		
		@Autowired
		private AreaService areaservice;
		
	    @PostMapping("/addArea")
	    public AreaDomain addarea(@RequestBody AreaDomain area) throws Exception{
	        return areaservice.createArea(area);
	    }

	    @GetMapping("/AreaById/{id}")
	    public AreaDomain findAreaById(@PathVariable int id)throws Exception {
	        return areaservice.getAreaById(id);
	    }

	    @GetMapping("/areas")
	    public List<AreaDomain> findAllArea()throws Exception {
	        return  areaservice.getAllAreas();
	    }
	    
	    @PutMapping("/update")
	    public AreaDomain updateArea(@RequestBody AreaDomain area )throws Exception {
	    	return areaservice.updateArea(area);

	    }

	    @DeleteMapping("/delete/{id}")
	    public String deleteArea(@PathVariable int id)throws Exception {
	        return areaservice.deleteArea(id);
	    }
	}


