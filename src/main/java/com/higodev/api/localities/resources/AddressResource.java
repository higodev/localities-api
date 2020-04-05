package com.higodev.api.localities.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.higodev.api.localities.dtos.AddressDto;
import com.higodev.api.localities.services.AddressService;

import io.swagger.annotations.Api;

@Api(tags = "Adresses", description = "List of addresses searched by postal code, city, state and street")
@RestController
@RequestMapping(path = "/adresses")
public class AddressResource {
	
	@Autowired
	private AddressService service;

	@GetMapping(path = "/postalCode/{postalCode}")
	public AddressDto findByCodePostal(@PathVariable("postalCode") String postalCode) {
		return service.findByCodePostal(postalCode);
	}
	
}
