package com.se.Domain.Bussiness;

import com.se.Domain.Auth.JwtUser;
import com.se.Domain.Auth.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by clevo on 2017/7/11.
 */
public final class JwtUserFactory {
    private JwtUserFactory(){};

    public static JwtUser create (User user){
        Role role = user.getRole();
        return new JwtUser(
            user.getId(),
            user.getUsername(),
            user.getPassword(),
            mapToGrandAuthorities(role),
            user.getLastPasswordResetDate(),
            user.getFullname()
                );
    }

    private static List<GrantedAuthority> mapToGrandAuthorities(Role role) {
        String str[] = role.getRolename().split(",");
        List<String> strs = Arrays.asList(str);

        return strs.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
