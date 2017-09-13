package com.se.Service.Business.Impl;

import com.se.Domain.Business.*;
import com.se.Repository.Jpa.*;
import com.se.Service.Business.ElectiveCourseService;
import com.se.Service.Business.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
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
    int COURSENUM_LIMIT =1;

    @Override
    public ElectiveCourse create(int roomId, Long adminClassId, Long virtualClassId,
                                 Long teacherId, int periodId, int subjectId, int weekday, int capability){
        Room room = roomRepository.findOne(roomId);
//        AdminClass adminClass = adminClassRepository.findOne(adminClassId);
//        VirtualClass virtualClass = (virtualClassId != null)?virtualClassRepository.findOne(virtualClassId):null;
        Teacher teacher = teacherRepository.findOne(teacherId);
        Period period = periodRepository.findOne(periodId);
        Subject subject = subjectRepository.findOne(subjectId);
        ElectiveCourse electiveCourse = new ElectiveCourse(room,teacher,null,subject,period,null,weekday,capability,0);
        return electiveCourseRepository.save(electiveCourse);
    }

    @Override
    public void delete(Long courseId) {
        electiveCourseRepository.delete(courseId);
        return;
    }
    @Override
    public ElectiveCourse update(Long courseId, int roomId, Long adminClassId, Long virtualClassId,
                         Long teacherId, int periodId, int subjectId, int weekday,int capability) {
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
        return electiveCourseRepository.save(course);
    }

	@Override
	public List<ElectiveCourse> findAll() {
		return electiveCourseRepository.findAll();
	}
@Override
@Transactional
    public Boolean select(Long courseId){
        Student student = studentRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        ElectiveCourse electiveCourse = electiveCourseRepository.findOne(courseId);
        if(electiveCourse.getNumber()<electiveCourse.getCapability()&&findAllSelected().size()<COURSENUM_LIMIT){
            electiveCourse.setNumber(electiveCourse.getNumber()+1);
            electiveCourse.getStudents().add(student);
            electiveCourseRepository.save(electiveCourse);
            return true;
        }
        else{
            return false;
        }
}
    @Override
    public List<ElectiveCourse> findAllSelected(){
        return studentRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getElectiveCourses();
    }
    @Override
    @Transactional
    public void dropAll(){
        List<ElectiveCourse> selectedCourses = findAllSelected();
        Student student = studentRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        try{
        for(ElectiveCourse electiveCourse : selectedCourses){
            electiveCourse.getStudents().remove(student);
            electiveCourse.setNumber(electiveCourse.getNumber()-1);
            electiveCourseRepository.save(electiveCourse);
        }} catch (Exception e){e.printStackTrace();}
        return;
    }

}
