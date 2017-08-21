package com.se.Repository.Jpa;

import com.se.Domain.Business.AdminClass;
import com.se.Domain.Business.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by clevo on 2017/7/20.
 */
public interface CourseRepository extends JpaRepository<Course,Long> {
    Collection<? extends Course> findByAdminClass(AdminClass one);
}
