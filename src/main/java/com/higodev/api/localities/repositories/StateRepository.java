package com.higodev.api.localities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.higodev.api.localities.domains.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{
	List<State> findByUf(String uf);
}
