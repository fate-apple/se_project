package com.se.Service.Business.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.Domain.Business.Student;
import com.se.Repository.Jpa.StudentRepository;
import com.se.Service.Business.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;


	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

}
