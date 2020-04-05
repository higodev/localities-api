package com.higodev.api.localities.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.higodev.api.localities.domains.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
	Optional<Address> findByPostalCode(String postalCode);
}
