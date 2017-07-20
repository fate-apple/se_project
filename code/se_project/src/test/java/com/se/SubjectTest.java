package com.se;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.se.Domain.Business.Subject;
import com.se.Repository.Jpa.SubjectRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubjectTest {
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Test
	public void SubjectTest(){
		subjectRepository.save(new Subject("English"));
		subjectRepository.save(new Subject("Chinese"));
		subjectRepository.save(new Subject("Math"));
		
		assertEquals(3,subjectRepository.findAll().size());
		
		assertEquals("English",subjectRepository.findOne(1).getTitle());
		
		subjectRepository.delete(3);
		
		assertEquals(false,subjectRepository.exists(3));
	}
}
