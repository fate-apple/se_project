package com.se.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.se.domain.Period;

@RepositoryRestResource
public interface PeriodRepository extends JpaRepository<Period,Integer> {
	List<Period> findAll();
}
