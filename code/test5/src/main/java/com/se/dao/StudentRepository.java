package com.se.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.se.domain.Student;
@EnableJpaRepositories
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
