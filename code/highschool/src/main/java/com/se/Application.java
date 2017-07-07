package com.se;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.se.dao.UserRepository;
import com.se.domain.Role;
import com.se.domain.User;

@SpringBootApplication
public class Application {
	@Autowired
	UserRepository userrepository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
//	public void datatest(){
//		Role role =new Role("admin");
//		
//		User user= new User("s","jw","admin","admin",role);
//		userrepository.save(user);
//	}
	
//	public void datatest(){
//		if (MongoOperations.collectionExists(Role.class))
//			MongoOperations.dropCollection(Role.class);
//
//		Role[] roles = new Role[] {
//			new Role("admin"),
//			new Role("user")
//		};
//
//		mongoOperations.insert(Arrays.asList(roles), Role.class);
//		if (mongoOperations.collectionExists(User.class))
//			mongoOperations.dropCollection(User.class);
//
//		User[] users = new User[]{
//			new User(
//				"deniz1",
//				"güzel1",
//				"denizmaradona1",
//				new BCryptPasswordEncoder().encode("password123"),
//				new Role("user")
//			),
//			new User(
//				"deniz2",
//				"güzel2",
//				"denizmaradona2",
//				new BCryptPasswordEncoder().encode("password123"),
//				new Role("user")
//			),
//			new User(
//				"deniz3",
//				"güzel3",
//				"denizmaradona3",
//				new BCryptPasswordEncoder().encode("password123"),
//				new Role("user")
//			)
//		};
//		mongoOperations.insert(Arrays.asList(users), User.class);
//	}

	
}
