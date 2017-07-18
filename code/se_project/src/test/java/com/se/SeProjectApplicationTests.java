package com.se;

import com.se.Domain.Auth.Role;
<<<<<<< HEAD
import com.se.Domain.Bussiness.User;
=======
import com.se.Domain.Business.User;
>>>>>>> cf14035ebec2295d395762a50c1696656ddd5378
import com.se.Repository.Jpa.RoleRepository;
import com.se.Repository.Jpa.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeProjectApplicationTests {
	@Autowired
	UserRepository ur;
	@Autowired
	RoleRepository rr;

	Role role = new Role(1, "admin");
	Date date = new Date();
//	User user = new User("root","root",rr.findOne(1),date,"sjw");
	@Test
	public void contextLoads() {
		Role role = new Role(1, "admin");
		rr.save(role);
	}
//		try{
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
//		Date date = sdf.parse("1996.06.22");} catch (ParseException e){System.out.println(e.getMessage());
//		Date date = new Date();
//		User user = new User(1l,"root","root",rr.findOne(1),date,"sjw");
//		ur.save(user);
//
//	@Test
//	public void contextLoads2() {
//
//		ur.save(user);
//	}

}
