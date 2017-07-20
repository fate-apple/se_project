package com.se.Repository.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.Domain.Business.Student;


public interface StudentRepository extends JpaRepository<Student,Long>{
}