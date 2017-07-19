package com.se.Service.Business.Impl;

import java.util.*;

import com.se.Domain.Auth.Role;
import com.se.Domain.Business.AdminClass;
import com.se.Domain.Business.Room;
import com.se.Domain.Business.Teacher;
import com.se.Repository.Jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.se.Domain.Business.Student;
import com.se.Service.Business.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
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

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    //
//	@Override
//	public Student create(String username, String password, String fullname, int roomId, Boolean gender){
//		Role role= roleRepository.findByRolename("ROLE_TEACHER");
//		Room room =roomRepository.findByRoomId(roomId);
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		if (userRepository.findByUsername(username) != null) {
//			return null;
//		}
//		Teacher teacher =new Teacher(username,encoder.encode(password),role,fullname,room,gender);
//		teacherRepository.save(teacher);
//		return teacher;
//	}
//	@Override
//	public Teacher update(Long id, String username, String fullname, int roomId, Boolean gender){
////        if(teacherRepository.findOne(id)==null)
//		Teacher teacher = teacherRepository.findOne(id);
//		teacher.setUsername(username);
//		teacher.setFullname(fullname);
//		teacher.setRoom(roomRepository.findOne(roomId));
//		teacher.setGender(gender);
//		teacherRepository.save(teacher);
//		return teacher;
//	}
//
//	@Override
//	public void delete(Long id){
//		teacherRepository.delete(id);
//	}
    @Override
    public List<Student> findByAdminClass(AdminClass adminClass) {
        return studentRepository.findByAdminClass(adminClass);
    }

    @Override
    public List<Student> findByAdminClasses(String classes) {
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
}