package com.se.Repository.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.Domain.Business.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {
}