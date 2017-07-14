package com.se.Repository.Jpa;

import com.se.Domain.Auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by clevo on 2017/7/11.
 */
@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role,Integer>{

    Role findByRolename(String role_user);
}
