package com.higodev.api.localities.dtos;

import com.higodev.api.localities.domains.Address;

import lombok.Data;

@Data
public class AddressDto {

	private String postalCode;
	private String address;
	private String complement;
	private String neighborhood;
	private String city;
	private String uf;
	private String ibge;
	
	public AddressDto(Address address) {
		this.postalCode = address.getPostalCode();
		this.address = address.getAddress();
		this.complement = address.getComplement();
		this.neighborhood = address.getNeighborhood();
		this.city = address.getCity();
		this.uf = address.getUf();
		this.ibge = address.getIbge();
	}
}
