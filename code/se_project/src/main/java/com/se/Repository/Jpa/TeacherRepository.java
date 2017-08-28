package com.se.Repository.Jpa;

import com.se.Domain.Business.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by clevo on 2017/7/18.
 */
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
