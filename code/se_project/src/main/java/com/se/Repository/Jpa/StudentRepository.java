package com.se.Repository.Jpa;

import com.se.Domain.Business.AdminClass;
import com.se.Domain.Business.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by clevo on 2017/7/18.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByAdminClass(AdminClass adminClass);


    Student findByUsername(String studentrname);
}


