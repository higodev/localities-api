package com.higodev.api.localities.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.higodev.api.localities.dtos.StateDto;
import com.higodev.api.localities.repositories.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository repository;
	
	public List<StateDto> findAll(){
		return repository.findAll().stream().map(s -> new StateDto(s)).collect(Collectors.toList());
	}

	public List<StateDto> findByUf(String uf){
		return repository.findByUf(uf).stream().map(s -> new StateDto(s)).collect(Collectors.toList());
	}
	
}
