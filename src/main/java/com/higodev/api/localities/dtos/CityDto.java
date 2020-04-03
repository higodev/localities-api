package com.higodev.api.localities.dtos;

import com.higodev.api.localities.domains.City;

import lombok.Data;

@Data
public class CityDto {
	private String city;
	private String ibge;
	
	public CityDto(City city) {
		this.city = city.getCity();
		this.ibge = city.getIbge();
	}
}
