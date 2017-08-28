package com.se.Service.Business.Impl;

import com.se.Domain.Business.User;
import com.se.Repository.Jpa.UserRepository;
import com.se.Service.Business.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSerivceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
