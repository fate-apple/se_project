package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.StudentRepository;
import com.demo.entity.Student;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional
	public void saveStudentList(List<Student> students){
		studentRepository.save(students);
	}
}
