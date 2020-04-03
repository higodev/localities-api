package com.higodev.api.localities.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.higodev.api.localities.dtos.CityDto;
import com.higodev.api.localities.services.CityService;

@RestController
@RequestMapping(path = "cities")
public class CityResource {
	
	@Autowired
	private CityService service;

	@GetMapping
	public List<CityDto> findAll(){
		return service.findAll();
	}
	
	@GetMapping(path = "/{cityId}")
	public CityDto findById(@PathVariable("cityId") long cityId) {
		return service.findById(cityId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	
}
