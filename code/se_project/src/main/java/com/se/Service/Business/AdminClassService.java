package com.se.Service.Business;

import com.se.Domain.Business.AdminClass;
import com.se.Repository.Jpa.AdminClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by clevo on 2017/7/18.
 */
public interface AdminClassService {


    List<AdminClass> findAll();

    List<AdminClass> findByGrade(int grade);

    AdminClass create(String username, String password, String fullname, Long teacherId, int roomId, int grade);

    AdminClass update(Long id, String username, String fullname, Long teacherId, int roomId, int grade);

    void delete(Long id);

    Map<String, Object> getClassByGrades(String grades);
}
