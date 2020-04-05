package com.higodev.api.localities.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.higodev.api.localities.dtos.StateDto;
import com.higodev.api.localities.services.StateService;

import io.swagger.annotations.Api;

@Api(tags = "States", description = "List of states in Brazil")
@RestController
@RequestMapping(path = "/states")
public class StateResource {

	@Autowired
	private StateService service;
	
	@GetMapping
	public List<StateDto> findAll(){
		return service.findAll();
	}
	
	@GetMapping(path = "/uf/{uf}")
	public List<StateDto> findByUf(@PathVariable(value = "uf") String uf) {
		return service.findByUf(uf);
	}
	
}
