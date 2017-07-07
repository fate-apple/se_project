package com.se;


import com.se.domain.Role;
import com.se.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestData {
	@Autowired
	private MongoOperations mongoOperations;

	@Test
	public void generateRoles() {
		if (mongoOperations.collectionExists(Role.class))
			mongoOperations.dropCollection(Role.class);

		Role[] roles = new Role[] {
			new Role("admin"),
			new Role("user")
		};

		mongoOperations.insert(Arrays.asList(roles), Role.class);
	}

	@Test
	public void generateUsers() {
		if (mongoOperations.collectionExists(User.class))
			mongoOperations.dropCollection(User.class);

		User[] users = new User[]{
			new User(
				"s",
				"jw1",
				"sjw",
				new BCryptPasswordEncoder().encode("sjw1"),
				new Role("user")
			),
			new User(
				"s",
				"jw2",
				"sjw2",
				new BCryptPasswordEncoder().encode("sjw2"),
				new Role("user")
			),
			new User(
				"c",
				"sy",
				"csy",
				new BCryptPasswordEncoder().encode("csy"),
				new Role("admin")
			),
			
			new User("g","c","g1c1",new BCryptPasswordEncoder().encode("csy"),new Role("user"))
		};
		mongoOperations.insert(Arrays.asList(users), User.class);
	}


}