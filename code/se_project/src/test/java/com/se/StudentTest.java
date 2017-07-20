package com.se;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.se.Domain.Business.Student;
import com.se.Repository.Jpa.AdminClassRepository;
import com.se.Repository.Jpa.StudentRepository;
import com.se.Repository.Jpa.VirtualClassRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {
	@Autowired 
	private StudentRepository studentRepository;
	@Autowired
	private AdminClassRepository adminClassRepository;
	@Autowired
	private VirtualClassRepository virtualClassRepository;
	
	@Test
	public void StudentTest(){
		studentRepository.save(new Student(adminClassRepository.findOne((long) 9),virtualClassRepository.findOne((long) 2),true,new Date()));
		studentRepository.save(new Student(adminClassRepository.findOne((long) 9),virtualClassRepository.findOne((long) 3),false,new Date()));
		studentRepository.save(new Student(adminClassRepository.findOne((long) 9),virtualClassRepository.findOne((long) 2),true,new Date()));
		
		assertEquals(3,studentRepository.findAll().size());
		
		assertEquals(true,studentRepository.findOne((long) 14).getGender());
		
		studentRepository.delete((long) 16);
		
		assertEquals(false,studentRepository.exists((long) 16));
		
		
	}
}
