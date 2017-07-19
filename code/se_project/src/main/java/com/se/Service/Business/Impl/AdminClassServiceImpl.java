package com.se.Service.Business.Impl;

import com.se.Domain.Auth.Role;
import com.se.Domain.Business.AdminClass;
import com.se.Domain.Business.Room;
import com.se.Domain.Business.Teacher;
import com.se.Repository.Jpa.*;
import com.se.Service.Business.AdminClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * Created by clevo on 2017/7/18.
 */
@Service
public class AdminClassServiceImpl implements AdminClassService{
    @Autowired
    private AdminClassRepository adminClassRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeacherRepository teacherRepository;


    @Override
    public List<AdminClass> findAll(){
        return adminClassRepository.findAll();
    }
    @Override
    public List<AdminClass> findByGrade(int grade){return adminClassRepository.findByGrade(grade);}

    @Override
    public AdminClass create(String username, String password, String fullname, Long teacherId, int roomId, int grade){
        Role role= roleRepository.findByRolename("ROLE_CLASS");
        Room room =roomRepository.findByRoomId(roomId);
        Teacher teacher = teacherRepository.findOne(teacherId);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (userRepository.findByUsername(username) != null) {
            return null;
        }
        AdminClass adminClass =new AdminClass(username,encoder.encode(password),role,fullname,teacher,room,grade);
        adminClassRepository.save(adminClass);
        return adminClass;
    }
    @Override
    public AdminClass update(Long id, String username, String fullname,  Long teacherId, int roomId, int grade){
//        if(adminClassRepository.findOne(id)==null) 
        AdminClass adminClass = adminClassRepository.findOne(id);
        adminClass.setUsername(username);
        adminClass.setFullname(fullname);
        adminClass.setRoom(roomRepository.findOne(roomId));
        adminClass.setTeacher(teacherRepository.findOne(teacherId));
        adminClass.setGrade(grade);
        adminClassRepository.save(adminClass);
        return adminClass;
    }

    @Override
    public void delete(Long id){
        adminClassRepository.delete(id);
    }
    @Override
    public Map<String,Object> getClassByGrades(String grade){
        String[] gradesStr = grade.split(",");
        Set<Integer> gradesInt = new HashSet<Integer>();
        for(String temp : gradesStr){
                    gradesInt.add(Integer.parseInt(temp));
        }
        Map<String,Object> classes = new HashMap<String,Object>();
        List<String> classname = new ArrayList<String> ();
        List<Long> classid = new ArrayList<Long> ();
        int classnum = 0;

        Set<AdminClass> resultSet =adminClassRepository.findByGradeIn(gradesInt);
        for (AdminClass adminClass: resultSet){
            classname.add(adminClass.getFullname());
            classid.add(adminClass.getId());
            classnum++;
        }
        classes.put("classname", classname);
        classes.put("classid", classid);
        classes.put("classnum",classnum);
        System.out.println(classes);
        return classes;

    }
}
