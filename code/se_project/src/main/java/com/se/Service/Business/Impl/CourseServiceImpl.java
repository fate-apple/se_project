package com.se.Service.Business.Impl;

import com.se.Domain.Business.*;
import com.se.Repository.Jpa.*;
import com.se.Service.Business.CourseSerivce;
import com.se.Service.Business.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;


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
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PeriodService periodService;
    @Autowired
    UserRepository userRepository;

    @Override
    public Course create(int roomId, Long adminClassId, Long virtualClassId,
                         Long teacherId, int periodId, int subjectId, int weekday) {
        Room room = roomRepository.findOne(roomId);
        AdminClass adminClass = adminClassRepository.findOne(adminClassId);
        VirtualClass virtualClass = (virtualClassId != null)?virtualClassRepository.findOne(virtualClassId):null;
        Teacher teacher = teacherRepository.findOne(teacherId);
        Period period = periodRepository.findOne(periodId);
        Subject subject = subjectRepository.findOne(subjectId);
        Course course = new Course(room, teacher, virtualClass, subject, period, adminClass, weekday);
        return courseRepository.save(course);
    }

    @Override
    public Course update(Long courseId, int roomId, Long adminClassId, Long virtualClassId,
                         Long teacherId, int periodId, int subjectId, int weekday) {
        Room room = roomRepository.findOne(roomId);
        AdminClass adminClass = (adminClassId != null) ? adminClassRepository.findOne(adminClassId) : null;
        VirtualClass virtualClass = (virtualClassId != null) ? virtualClassRepository.findOne(virtualClassId) : null;
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
        course.setWeekday(weekday);
        return courseRepository.save(course);
    }

    @Override
    public void delete(Long courseId) {
        courseRepository.delete(courseId);
        return;
    }

    @Override
    public List<Course> findByAdminClasses(String adminClasses) {
        List<Course> courses = new ArrayList<Course>();
        if (adminClasses != "") {
            String[] classesStr = adminClasses.split(",");
            Set<Long> classesId = new HashSet<Long>();
            for (String classStr : classesStr) {
                classesId.add(Long.parseLong(classStr));
            }

            for (Long classId : classesId) {
                courses.addAll(courseRepository.findByAdminClass(adminClassRepository.findOne(classId)));
            }
        }
        return courses;
    }
    @Override
    public List<Course> findByStudentname(String studentrname){
        AdminClass adminClass=studentRepository.findByUsername(studentrname).getAdminClass();
             List<Course> courses = courseRepository.findByAdminClass(adminClass);
             return courses;
    }

    @Override
    public List<Course> findNextCourse(){
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        AdminClass adminClass=adminClassRepository.findByUsername(user.getUsername());
        Calendar now = Calendar.getInstance();
        int weekday = now.get(Calendar.DAY_OF_WEEK);
        Date date = new Date(System.currentTimeMillis());
        Period period = periodService.findByDate(date);
        Period nextperiod =periodRepository.findOne(period.getId()+1);
        List<Course>  list = new ArrayList<>();
        list.addAll(courseRepository.findByAdminClassAndWeekdayAndPeriod(adminClass,weekday,period));
        list.addAll(courseRepository.findByAdminClassAndWeekdayAndPeriod(adminClass,weekday,nextperiod));
        return list;
    }

@Override
    public List<Course> findAll(){
    GrantedAuthority[] authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray(new GrantedAuthority[0]);
    GrantedAuthority authority = authorities[0];
    String role = authority.getAuthority();
    User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    if(role.matches("ROLE_STUDENT")) return findByStudentname(user.getUsername());
    if(role.matches("ROLE_CLASS")) return courseRepository.findByAdminClass(adminClassRepository.findByUsername(user.getUsername()));
    return null;
}


}
