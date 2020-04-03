package com.higodev.api.localities.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.higodev.api.localities.domains.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{
	Optional<City> findByIbge(String ibge);
}
