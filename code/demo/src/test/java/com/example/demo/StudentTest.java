package com.example.demo;

import java.util.ArrayList;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.dao.StudentRepository;
import com.demo.entity.Student;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentTest {
	
	@Autowired
	private StudentRepository studentRespository;
	@Test
	public void testCrudRepository(){
		Long cnt = this.studentRespository.count();  
        System.out.println("studnetPO total count: " + cnt); 
	}
}
