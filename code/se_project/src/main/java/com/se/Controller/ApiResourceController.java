package com.se.Controller;

import com.se.Repository.Jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by clevo on 2017/7/20.
 */
@RestController
@RequestMapping(name="/api/resource",method = RequestMethod.GET)
public class ApiResourceController {
    @Autowired
    PeriodRepository periodRepository;
    @Autowired
    AdminClassRepository adminClassRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    VirtualClassRepository virtualClassRepository;
    public ResponseEntity<?> period(){
        return ResponseEntity.ok(periodRepository.findAll());
    }
}
