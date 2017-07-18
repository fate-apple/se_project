package com.se.Repository.Jpa;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.se.Domain.Business.Period;

@RepositoryRestResource
public interface PeriodRepository extends JpaRepository<Period,Integer> {
	List<Period> findAll();
}
