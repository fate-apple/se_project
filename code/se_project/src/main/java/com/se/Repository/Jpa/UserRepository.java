package com.se.Repository.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.se.Domain.Business.User;

/**
 * Created by clevo on 2017/7/10.
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
