package com.se;

import com.se.Domain.Auth.Role;
import com.se.Domain.Business.AdminClass;
import com.se.Domain.Business.Information;
import com.se.Domain.Business.Room;
import com.se.Domain.Business.User;
import com.se.Repository.Jpa.AdminClassRepository;
import com.se.Repository.Jpa.InformationRepository;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeProjectApplicationTests {
	@Autowired
	UserRepository ur;
	@Autowired
	RoleRepository rr;
	@Autowired
	InformationRepository informationRepository;
	@Autowired
	AdminClassRepository adminClassRepository;

	Role role = new Role(1, "admin");
	Date date = new Date();
//	User user = new User("root","root",rr.findOne(1),date,"sjw");
	@Test
	public void contextLoads() {
		Set<AdminClass> receivers = new HashSet<>();

		User user = ur.findOne(5L);
		AdminClass adminClass =adminClassRepository.findOne(5L);
		AdminClass adminClass2 =adminClassRepository.findOne(8L);
		receivers.add(adminClass);
		receivers.add(adminClass2);

		Information information=new Information(new java.sql.Date(System.currentTimeMillis()),"test","test",user,receivers);

		informationRepository.save(information);
Information information2 =informationRepository.findOne(27);
		List<Information> set  = adminClass.getReceived_information();
		List<Information> list2 = informationRepository.findByInformer(user);
	User user2 = new User("1","1",role,"1");
//		rr.save(role);
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
