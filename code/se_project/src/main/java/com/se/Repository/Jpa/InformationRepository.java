package com.se.Repository.Jpa;

import com.se.Domain.Business.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information,Integer> {
}
