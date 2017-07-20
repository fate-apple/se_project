package com.se.Service.Business.Impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.se.Domain.Auth.Role;
import com.se.Domain.Business.*;
import com.se.Repository.Jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.se.Service.Business.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private AdminClassRepository adminClassRepository;
    @Autowired
    private VirtualClassRepository virtualClassRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }


    @Override
    public List<Student> findByAdminClass(AdminClass adminClass) {
        return studentRepository.findByAdminClass(adminClass);
    }

    @Override
    public List<Student> findByAdminClasses(String classes) {
        if (classes == "") return null;
        String[] classesStr = classes.split(",");
        Set<Long> classesId = new HashSet<Long>();
        for (String classStr : classesStr) {
            classesId.add(Long.parseLong(classStr));
        }
        List<Student> students = new ArrayList<Student>();
        for (Long classId : classesId) {
            students.addAll(studentService.findByAdminClassId(classId));
        }
        return students;
    }

    @Override
    public Collection<? extends Student> findByAdminClassId(Long classId) {
        return studentRepository.findByAdminClass(adminClassRepository.findOne(classId));
    }

    @Override
    public Student create(String username, String password, String fullname,
                          Long adminClassId, Long virtualClassId, boolean gender, String enrollDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = sdf.parse(enrollDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Role role = roleRepository.findByRolename("ROLE_STUDENT");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (userRepository.findByUsername(username) != null) {
            return null;
        }
        AdminClass adminClass = adminClassRepository.findOne(adminClassId);
        VirtualClass virtualClass = virtualClassRepository.findOne(virtualClassId);
        Student student = new Student(username, encoder.encode(password), role, fullname, adminClass, virtualClass, gender, date);
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student update(Long id, String username, String fullname, Long adminClassId, Long virtualClassId, boolean gender, String enrollDate) {
//        if(studentRepository.findOne(id)==null)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = sdf.parse(enrollDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Role role = roleRepository.findByRolename("ROLE_STUDENT");
        AdminClass adminClass = adminClassRepository.findOne(adminClassId);
        VirtualClass virtualClass = virtualClassRepository.findOne(virtualClassId);

        Student student = studentRepository.findOne(id);
        student.setUsername(username);
        student.setFullname(fullname);
        student.setAdminClass((adminClass));
        student.setVirtualClass(virtualClass);
        student.setGender(gender);
        student.setEnrollDate(date);
        studentRepository.save(student);
        return student;
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(id);
    }
}