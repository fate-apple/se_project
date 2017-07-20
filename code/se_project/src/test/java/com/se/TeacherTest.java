package com.se;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.se.Domain.Business.Teacher;
import com.se.Repository.Jpa.RoomRepository;
import com.se.Repository.Jpa.TeacherRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherTest {
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private RoomRepository roomRepository;
	
	@Test
	public void TeacherTest(){
		teacherRepository.save(new Teacher(roomRepository.findOne(1),true));
		teacherRepository.save(new Teacher(roomRepository.findOne(2),false));
		teacherRepository.save(new Teacher(roomRepository.findOne(2),true));
		teacherRepository.save(new Teacher(roomRepository.findOne(2),true));
		teacherRepository.save(new Teacher(roomRepository.findOne(1),true));
		teacherRepository.save(new Teacher(roomRepository.findOne(1),false));
		
		assertEquals(6,teacherRepository.findAll().size());
		
		assertEquals(true, teacherRepository.findOne((long) 1).getGender());
		
		teacherRepository.delete((long) 1);
		
		assertEquals(false,teacherRepository.exists((long) 1));
	}
}
