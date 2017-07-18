package com.se.Service.Business.Impl;

import com.se.Domain.Business.Teacher;
import com.se.Repository.Jpa.TeacherRepository;
import com.se.Service.Business.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by clevo on 2017/7/18.
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }
}
