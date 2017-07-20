package com.se;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.se.Domain.Business.VirtualClass;
import com.se.Repository.Jpa.VirtualClassRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VirtualClassTest {
	@Autowired
	private VirtualClassRepository virtualClassRepository;
	
	@Test
	public void VirtualClassTest(){
		
		virtualClassRepository.save(new VirtualClass((long) 1,"math"));
		virtualClassRepository.save(new VirtualClass((long)2,"chinese"));
		virtualClassRepository.save(new VirtualClass((long)3,"music"));
		assertEquals(3,virtualClassRepository.findAll().size());
		
		assertEquals("math",virtualClassRepository.findOne((long)1).getName());
		
		virtualClassRepository.delete((long)1);
		assertEquals(false,virtualClassRepository.exists((long)1));
	}
}
