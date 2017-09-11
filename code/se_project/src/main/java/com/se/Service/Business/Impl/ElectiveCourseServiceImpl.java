package com.se.Service.Business.Impl;

import com.se.Domain.Business.*;
import com.se.Repository.Jpa.*;
import com.se.Service.Business.CourseSerivce;
import com.se.Service.Business.ElectiveCourseService;
import com.se.Service.Business.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElectiveCourseServiceImpl implements ElectiveCourseService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    AdminClassRepository adminClassRepository;
    @Autowired
    VirtualClassRepository virtualClassRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    PeriodRepository periodRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ElectiveCourseRepository electiveCourseRepository;
    @Autowired
    PeriodService periodService;
    @Override
    public ElectiveCourse create(int roomId, Long adminClassId, Long virtualClassId,
                                 Long teacherId, int periodId, int subjectId, int weekday, int capability){
        Room room = roomRepository.findOne(roomId);
        AdminClass adminClass = adminClassRepository.findOne(adminClassId);
        VirtualClass virtualClass = (virtualClassId != null)?virtualClassRepository.findOne(virtualClassId):null;
        Teacher teacher = teacherRepository.findOne(teacherId);
        Period period = periodRepository.findOne(periodId);
        Subject subject = subjectRepository.findOne(subjectId);
        ElectiveCourse electiveCourse = new ElectiveCourse(room,teacher,virtualClass,subject,period,adminClass,weekday,capability,0);
        return electiveCourseRepository.save(electiveCourse);
    }

    @Override
    public void delete(Long courseId) {
        electiveCourseRepository.delete(courseId);
        return;
    }
    @Override
    public Course update(Long courseId, int roomId, Long adminClassId, Long virtualClassId,
                         Long teacherId, int periodId, int subjectId, int weekday,int capability,int number) {
        Room room = roomRepository.findOne(roomId);
        AdminClass adminClass = (adminClassId != null) ? adminClassRepository.findOne(adminClassId) : null;
        VirtualClass virtualClass = (virtualClassId != null) ? virtualClassRepository.findOne(virtualClassId) : null;
        Teacher teacher = teacherRepository.findOne(teacherId);
        Period period = periodRepository.findOne(periodId);
        Subject subject = subjectRepository.findOne(subjectId);
       ElectiveCourse course = electiveCourseRepository.findOne(courseId);
        if(adminClass!=null)course.setAdminClass(adminClass);
        if(room!=null)course.setRoom(room);
        if(virtualClass!=null) course.setVirtualClass(virtualClass);
        if(teacher!=null)course.setTeacher(teacher);
        if(period!=null)course.setPeriod(period);
        if(subject!=null) course.setSubject(subject);
        course.setWeekday(weekday);
        course.setCapability(capability);
        course.setNumber(number);
        return electiveCourseRepository.save(course);
    }

}
