package com.se.Service.Business.Impl;

import com.se.Domain.Auth.Role;
import com.se.Domain.Business.Room;
import com.se.Domain.Business.Teacher;
import com.se.Domain.Business.User;
import com.se.Repository.Jpa.RoleRepository;
import com.se.Repository.Jpa.RoomRepository;
import com.se.Repository.Jpa.TeacherRepository;
import com.se.Service.Auth.AuthService;
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
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AuthService authService;

    @Override
    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }

    @Override
    public Teacher create(String username, String password, String fullname, int room_id, Boolean gender){
        Role role= roleRepository.findByRolename("ROLE_TEACHER");
        Room room =roomRepository.findById(room_id);
        Teacher teacher =new Teacher(username,password,role,fullname,room,gender);
        teacherRepository.save(teacher);
        return teacher;
    }
}
