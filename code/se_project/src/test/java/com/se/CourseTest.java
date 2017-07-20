package com.se;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.se.Domain.Business.Course;
import com.se.Repository.Jpa.AdminClassRepository;
import com.se.Repository.Jpa.CourseRepository;
import com.se.Repository.Jpa.PeriodRepository;
import com.se.Repository.Jpa.RoomRepository;
import com.se.Repository.Jpa.SubjectRepository;
import com.se.Repository.Jpa.TeacherRepository;
import com.se.Repository.Jpa.VirtualClassRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseTest {
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private AdminClassRepository adminClassRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private PeriodRepository periodRepository;
	@Autowired
	private VirtualClassRepository virtualClassRepository;
	@Test
    public void CourseTest(){
    	courseRepository.save(new Course((long)1,roomRepository.findOne(1),teacherRepository.findOne((long) 2),
    	                                  virtualClassRepository.findOne((long) 2),subjectRepository.findOne(1),
    	                                  periodRepository.findOne(1),adminClassRepository.findOne((long) 9),1));
    	
        assertEquals(1,courseRepository.findAll().size());
        
        assertEquals((long)1,(long)courseRepository.findOne((long) 1).getCourseId());
        
        courseRepository.delete((long) 1);
        assertEquals(false,courseRepository.exists((long) 1));
    }
}
