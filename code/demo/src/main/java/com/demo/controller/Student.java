package com.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.StudentRepository;

@RestController
@RequestMapping("/Student")
public class Student {
	private static final Logger logger = LoggerFactory.getLogger(Student.class);

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/RepositoryTest")
    public Long RepositoryTest(){
    	Long cnt = studentRepository.count();  
        System.out.println("studnetPO total count: " + cnt); 
        return cnt;
    }
}
