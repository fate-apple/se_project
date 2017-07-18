package com.se.Service.Auth;

<<<<<<< HEAD
import com.se.Domain.Bussiness.JwtUserFactory;
import com.se.Domain.Bussiness.User;
=======
import com.se.Domain.Business.JwtUserFactory;
import com.se.Domain.Business.User;
>>>>>>> cf14035ebec2295d395762a50c1696656ddd5378
import com.se.Repository.Jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by clevo on 2017/7/11.
 */
@Service(value = "UserDetailsService")
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
