package com.se.service.impl;

import com.se.domain.User;
import com.se.dao.UserRepository;
import com.se.service.UserService;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component(value = "userServiceImpl")
public class UserServiceImpl extends GenericServiceImpl<User, String> implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findByFirstName(String name) {
		return userRepository.findByFirstName(name);
	}

	@Override
	public List<User> findAllByText(String text) {
		return userRepository.findAllBy(TextCriteria.forDefaultLanguage().matchingAny(text));
	}

	@Override
	public Optional<User> findByUserName(String username) {
		return userRepository.findByUserName(username);
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final Optional<User> user = userRepository.findByUserName(username);
		final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
		user.ifPresent(detailsChecker::check);
		return user.orElseThrow(() -> new UsernameNotFoundException("user not found."));
	}
}
