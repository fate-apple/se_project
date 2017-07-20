package com.se;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.se.Domain.Business.User;
import com.se.Repository.Jpa.RoleRepository;
import com.se.Repository.Jpa.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Test
	public void UserTest(){
		userRepository.save(new User("liumu","123",roleRepository.findOne(1),new Date(),"xixi"));
		userRepository.save(new User("root","123",roleRepository.findOne(2),new Date(),"lala"));
		userRepository.save(new User("fff","123",roleRepository.findOne(3),new Date(),"dddd"));
		userRepository.save(new User("ddd","123",roleRepository.findOne(3),new Date(),"saaa"));
		userRepository.save(new User("xixi","123",roleRepository.findOne(2),new Date(),"bbbb"));
		
		assertEquals(18,userRepository.findAll().size());
		
		assertEquals("liumu",userRepository.findOne((long) 22).getUsername());
		
		userRepository.delete((long) 26);
		
		assertEquals(false,userRepository.exists((long) 26));
	}
}
