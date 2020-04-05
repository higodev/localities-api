package com.higodev.api.localities.utils.viacep;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ViaCepWS {

	private static final String VIA_CEP = "https://viacep.com.br/ws/{cep}/json/";
	private static final String VIA_CEP_SEARCH = "viacep.com.br/ws/{uf}/{city}/{address}/json/";

	protected ViaCepDto findViaCepByPostalCode(String postalCode) {

		try {
			RestTemplate rest = new RestTemplate();
			ResponseEntity<ViaCepDto> viaCep = rest.exchange(
					VIA_CEP.replace("{cep}", postalCode), 
					HttpMethod.GET, 
					null,
					ViaCepDto.class);
			return viaCep.getBody();
		} catch (RuntimeException e) {
			return new ViaCepDto();
		}

	}

	protected List<ViaCepDto> findViaCepByUfAndCityAndAddress(String uf, String city, String address) {

		try {
			RestTemplate httpRequest = new RestTemplate();
			ResponseEntity<List<ViaCepDto>> rest = httpRequest.exchange(
					VIA_CEP_SEARCH.replace("{uf}", uf)
					.replace("{city}", city)
					.replace("{address}", address),
					HttpMethod.GET, 
					null, 
					new ParameterizedTypeReference<List<ViaCepDto>>(){});
			return rest.getBody();
		} catch (RuntimeException e) {
			return new ArrayList<ViaCepDto>();
		}
		
	}

}
