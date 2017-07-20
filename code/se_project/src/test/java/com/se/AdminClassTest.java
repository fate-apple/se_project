package com.se;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.se.Domain.Business.AdminClass;
import com.se.Repository.Jpa.AdminClassRepository;
import com.se.Repository.Jpa.RoomRepository;
import com.se.Repository.Jpa.TeacherRepository;

@RunWith(SpringRunner.class)
@SpringBootTest

public class AdminClassTest {
	@Autowired
	private AdminClassRepository adminClassRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private RoomRepository roomRepository;
	
	@Test
	public void AdminClassTest(){
		adminClassRepository.save(new AdminClass(teacherRepository.findOne((long) 2),roomRepository.findOne(1),5));
		adminClassRepository.save(new AdminClass(teacherRepository.findOne((long) 3),roomRepository.findOne(2),4));

		assertEquals(2,adminClassRepository.findAll().size());

		assertEquals(5,adminClassRepository.findOne((long) 9).getGrade());
		
		adminClassRepository.delete((long)10);
		
		assertEquals(false,adminClassRepository.exists((long)10));
	}
}
