package com.se.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.se.domain.Take;
@EnableJpaRepositories
public interface TakeRepository extends JpaRepository<Take,String> {

}
