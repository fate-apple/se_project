package com.se.Repository.Jpa;

<<<<<<< HEAD
import com.se.Domain.Bussiness.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.se.Domain.Business.User;

>>>>>>> cf14035ebec2295d395762a50c1696656ddd5378
/**
 * Created by clevo on 2017/7/10.
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
