package com.higodev.api.localities.services;

import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.higodev.api.localities.domains.Address;
import com.higodev.api.localities.repositories.AddressRepository;
import com.higodev.api.localities.utils.UtilDate;
import com.higodev.api.localities.utils.viacep.ViaCepDto;
import com.higodev.api.localities.utils.viacep.ViaCepWS;

@Service
public class AddressService extends ViaCepWS {

	@Autowired
	private AddressRepository repository;

	@Autowired
	private UtilDate utilDate;

	private String getPostalCodeTreated(String postalCode) {
		return postalCode
				.replace("-", "")
				.replace(" ", "")
				.replace(".", "")
				.trim();
	}
	
	public Address findByCodePostal(String postalCode) {

		String postalCodeTreated = getPostalCodeTreated(postalCode);
		Optional<Address> address = repository.findByPostalCode(postalCodeTreated);

		if (address.isPresent()) {

			Address addressFound = address.get();

			long daysRegister = utilDate.getIntervalDateTimeToNow(ChronoUnit.DAYS, addressFound.getDateRegister());

			if (daysRegister >= 180) {
				repository.deleteById(addressFound.getId());
			}

			return addressFound;

		} else {

			ViaCepDto viaCepDto = findViaCepByPostalCode(postalCodeTreated);
			Address addressNew = new Address(viaCepDto);
			addressNew.setPostalCode(postalCodeTreated);
			repository.save(addressNew);
			
			return addressNew;

		}

	}

}
