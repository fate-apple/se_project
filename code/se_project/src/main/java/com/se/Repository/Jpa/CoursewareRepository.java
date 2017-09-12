package com.se.Repository.Jpa;

import com.se.Domain.Business.AdminClass;
import com.se.Domain.Business.Courseware;
import com.se.Domain.Business.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursewareRepository extends JpaRepository<Courseware,Integer> {
//    List<Courseware> findByInformer(User user);

    List<Courseware> findByReceiversContaining(AdminClass byUsername);

    List<Courseware> findByUser(User user);
}
