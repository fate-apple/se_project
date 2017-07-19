package com.se.Service.Business;

import com.se.Domain.Business.AdminClass;
import com.se.Domain.Business.Student;
import java.util.List;

/**
 * Created by clevo on 2017/7/18.
 */
public interface StudentService {
    List<Student> findAll();

    List<Student> findByAdminClass (AdminClass adminClass);
}

