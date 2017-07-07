package com.se.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;import com.se.domain.User;
public interface UserService extends UserDetailsService{
	 List<User> findByFirstName(String firstname);
	 void insert(User user);

	void save(User user);

	void delete(User user);

	List<User> findAll();

	User findById(String id);

	Optional<User> findByUserName(String username);
	List<User> findAllByText(String text);
}
