package com.se.Service.Auth;

import com.se.Domain.Business.User;

/**
 * Created by clevo on 2017/7/11.
 */
public interface AuthService {
    User register(User userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}
