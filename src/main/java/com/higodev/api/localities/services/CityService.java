package com.higodev.api.localities.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.higodev.api.localities.dtos.CityDto;
import com.higodev.api.localities.repositories.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository repository;
	
	public List<CityDto> findAll(){
		return repository.findAll().stream().map(c -> new CityDto(c)).collect(Collectors.toList());
	}

	public List<CityDto> findByUf(String uf){
		return repository.findByUf(uf).stream().map(c -> new CityDto(c)).collect(Collectors.toList());
	}
	
	public Optional<CityDto> findByIbge(String ibge) {
		return repository.findByIbge(ibge).map(c -> new CityDto(c));
	}
	
}
