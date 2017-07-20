package com.se.Service.Business;

import com.se.Domain.Business.AdminClass;
import com.se.Domain.Business.Student;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by clevo on 2017/7/18.
 */
public interface StudentService {
    List<Student> findAll();

    List<Student> findByAdminClass (AdminClass adminClass);


    List<Student> findByAdminClasses(String classes);

    Collection<? extends Student> findByAdminClassId(Long classId);
}

