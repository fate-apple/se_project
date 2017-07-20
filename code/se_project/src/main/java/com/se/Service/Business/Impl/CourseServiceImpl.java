package com.se.Service.Business.Impl;

import com.se.Domain.Business.*;
import com.se.Repository.Jpa.*;
import com.se.Service.Business.CourseSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by clevo on 2017/7/20.
 */
@Service
public class CourseServiceImpl implements CourseSerivce {
    @Autowired
    CourseRepository courseRepository;
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

    @Override
    public Course create(int roomId, Long adminClassId, Long virtualClassId,
                         Long teacherId, int periodId, int subjectId, int weekday) {
        Room room = roomRepository.findOne(roomId);;
        AdminClass adminClass = adminClassRepository.findOne(adminClassId);
        VirtualClass virtualClass = virtualClassRepository.findOne(virtualClassId);
        Teacher teacher = teacherRepository.findOne(teacherId);
        Period period = periodRepository.findOne(periodId);
        Subject subject = subjectRepository.findOne(subjectId);
        Course course = new Course(room,teacher,virtualClass,subject,period,adminClass,weekday);
        return courseRepository.save(course);
    }
    @Override
    public Course update(Long courseId, int roomId, Long adminClassId, Long virtualClassId,
                         Long teacherId, int periodId, int subjectId, int weekday) {
        Room room = roomRepository.findOne(roomId);;
        AdminClass adminClass = adminClassRepository.findOne(adminClassId);
        VirtualClass virtualClass = virtualClassRepository.findOne(virtualClassId);
        Teacher teacher = teacherRepository.findOne(teacherId);
        Period period = periodRepository.findOne(periodId);
        Subject subject = subjectRepository.findOne(subjectId);
        Course course = courseRepository.findOne(courseId);
        course.setAdminClass(adminClass);
        course.setRoom(room);
        course.setVirtualClass(virtualClass);
        course.setTeacher(teacher);
        course.setPeriod(period);
        course.setSubject(subject);
        return courseRepository.save(course);
    }
    @Override
    public void delete(Long courseId){
        courseRepository.delete(courseId);
        return;
    }
}
