package com.se.Repository.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.Domain.Business.Course;


public interface CourseRepository extends JpaRepository<Course,Long>{
}