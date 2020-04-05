package com.higodev.api.localities.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.higodev.api.localities.domains.Address;
import com.higodev.api.localities.services.AddressService;

import io.swagger.annotations.Api;

@Api(tags = "Adresses", description = "List of addresses searched by zip code, city, state and street")
@RestController
@RequestMapping(path = "/adresses")
public class AddressResource {
	
	@Autowired
	private AddressService service;

	@GetMapping(path = "/postalCode/{postalCode}")
	public Address findByCodePostal(@PathVariable("postalCode") String postalCode) {
		return service.findByCodePostal(postalCode);
	}
	
}
