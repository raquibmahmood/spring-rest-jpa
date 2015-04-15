package com.spring.rest;

import java.util.Collection;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.rest.dao.Region;
import com.spring.rest.dao.RegionRepository;

@RestController
public class RegionController {

	@Autowired
	RegionRepository regionRepository;
	
	
	@RequestMapping(value = "/regions",method=RequestMethod.GET)
	public @ResponseBody String getAllRegion(){
		Iterable<Region> it =  regionRepository.findAll();
		Collection<Region> list = IteratorUtils.toList(it.iterator());
		ObjectMapper om = new ObjectMapper();
		String regions = "";
		try {
			regions = om.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return regions;
	}
	
	@RequestMapping(value = "/saveRegion", method=RequestMethod.POST, headers="Accept=application/json")
	@ResponseBody
	public String saveRegion(@RequestBody Region region){
		
		region = regionRepository.save(region);
		
		return getAllRegion();
	}
}
