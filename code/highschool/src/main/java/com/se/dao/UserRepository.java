package com.se.dao;

import com.se.domain.User;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends GenericRepository<User, String> {

	List<User> findByFirstName(String firstname);

	List<User> findByLastName(String lastname);

	Optional<User> findByUserName(String username);

	User deleteByUserName(String username);

	List<User> findAllBy(TextCriteria textCriteria);
}
