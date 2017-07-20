package com.se;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.se.Domain.Auth.Role;
import com.se.Repository.Jpa.RoleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleTest {

	@Autowired
	private RoleRepository roleRepository;
	
	@Test
	public void RoleTest() {
		roleRepository.save(new Role(0,"Admin"));
		roleRepository.save(new Role(1,"User"));
		roleRepository.save(new Role(2,"Passenger"));
		roleRepository.save(new Role(3,"Student"));
		roleRepository.save(new Role(4,"Teacher"));
		
		assertEquals(5, roleRepository.findAll().size());
		
        roleRepository.delete(0);
        
	    assertEquals(4, roleRepository.findAll().size());
	    
	    assertEquals("User", roleRepository.findOne(1).getRolename());
	    
	    assertEquals(true, roleRepository.exists(2));
	}
}
