package com.higodev.api.localities.dtos;

import com.higodev.api.localities.domains.State;

import lombok.Data;

@Data
public class StateDto {

	private String stateName;
	private String uf;
	
	public StateDto(State state) {
		this.stateName = state.getStateName();
		this.uf = state.getUf();
	}

}
