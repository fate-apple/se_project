package com.se.Service.Business.Impl;

<<<<<<< HEAD
import com.se.Domain.Business.Teacher;
import com.se.Repository.Jpa.TeacherRepository;
import com.se.Service.Business.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.se.Domain.Auth.Role;
import com.se.Domain.Business.Room;
import com.se.Domain.Business.Teacher;
import com.se.Domain.Business.User;
import com.se.Repository.Jpa.RoleRepository;
import com.se.Repository.Jpa.RoomRepository;
import com.se.Repository.Jpa.TeacherRepository;
import com.se.Repository.Jpa.UserRepository;
import com.se.Service.Auth.AuthService;
import com.se.Service.Business.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
>>>>>>> origin/csy
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by clevo on 2017/7/18.
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
<<<<<<< HEAD
=======
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
>>>>>>> origin/csy

    @Override
    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }
<<<<<<< HEAD
=======

    @Override
    public Teacher create(String username, String password, String fullname, int roomId, Boolean gender){
        Role role= roleRepository.findByRolename("ROLE_TEACHER");
        Room room =roomRepository.findByRoomId(roomId);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (userRepository.findByUsername(username) != null) {
            return null;
        }
        Teacher teacher =new Teacher(username,encoder.encode(password),role,fullname,room,gender);
        teacherRepository.save(teacher);
        return teacher;
    }
    @Override
    public Teacher update(Long id, String username, String fullname, int roomId, Boolean gender){
//        if(teacherRepository.findOne(id)==null) 
        Teacher teacher = teacherRepository.findOne(id);
        teacher.setUsername(username);
        teacher.setFullname(fullname);
        teacher.setRoom(roomRepository.findOne(roomId));
        teacher.setGender(gender);
        teacherRepository.save(teacher);
        return teacher;
    }

    @Override
    public void delete(Long id){
        teacherRepository.delete(id);
    }
>>>>>>> origin/csy
}
