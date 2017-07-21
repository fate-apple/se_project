package com.se;

import com.se.Domain.Auth.Role;
<<<<<<< HEAD
import com.se.Domain.Business.AdminClass;
import com.se.Domain.Business.Course;
import com.se.Domain.Business.Period;
import com.se.Domain.Business.Room;
import com.se.Domain.Business.Student;
import com.se.Domain.Business.Subject;
import com.se.Domain.Business.Teacher;
import com.se.Domain.Business.User;
import com.se.Domain.Business.VirtualClass;
import com.se.Repository.Jpa.AdminClassRepository;
import com.se.Repository.Jpa.CourseRepository;
import com.se.Repository.Jpa.PeriodRepository;
import com.se.Repository.Jpa.RoleRepository;
import com.se.Repository.Jpa.RoomRepository;
import com.se.Repository.Jpa.StudentRepository;
import com.se.Repository.Jpa.SubjectRepository;
import com.se.Repository.Jpa.TeacherRepository;
import com.se.Repository.Jpa.UserRepository;
import com.se.Repository.Jpa.VirtualClassRepository;

import java.sql.Time;
=======
import com.se.Domain.Business.User;
import com.se.Repository.Jpa.RoleRepository;
import com.se.Repository.Jpa.UserRepository;
>>>>>>> origin/csy
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

<<<<<<< HEAD
import static org.junit.Assert.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
=======
import java.text.ParseException;
import java.text.SimpleDateFormat;
>>>>>>> origin/csy
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeProjectApplicationTests {
<<<<<<< HEAD
	
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PeriodRepository periodRepository;
	@Autowired
	private VirtualClassRepository virtualClassRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired 
	private StudentRepository studentRepository;
	@Autowired
	private AdminClassRepository adminClassRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private CourseRepository courseRepository;


	@Test
	public void RoleTest() {
		roleRepository.save(new Role(0,"Admin"));
		roleRepository.save(new Role(1,"User"));
		roleRepository.save(new Role(2,"Passenger"));
		roleRepository.save(new Role(3,"Student"));
		roleRepository.save(new Role(4,"Teacher"));
		
		assertEquals(5, roleRepository.findAll().size());
		
        roleRepository.delete(0);
        
	    assertEquals(4, roleRepository.findAll().size());
	    
	    assertEquals("User", roleRepository.findOne(1).getRolename());
	    
	    assertEquals(true, roleRepository.exists(2));
	}
	

	@Test
	public void VirtualClassTest(){
		
		virtualClassRepository.save(new VirtualClass((long) 1,"math"));
		virtualClassRepository.save(new VirtualClass((long)2,"chinese"));
		virtualClassRepository.save(new VirtualClass((long)3,"music"));
		assertEquals(3,virtualClassRepository.findAll().size());
		
		assertEquals("math",virtualClassRepository.findOne((long)1).getName());
		
		virtualClassRepository.delete((long)1);
		assertEquals(false,virtualClassRepository.exists((long)1));
	}
	
	@Test
	public void RoomTest(){
		roomRepository.save(new Room(1,"dongshangyuan","303",100,"classroom"));
		roomRepository.save(new Room(2,"dongxiayuan","201",200,"meetingroom"));
		roomRepository.save(new Room(3,"dongzhongyuan","101",20,"restroom"));
		assertEquals(3,roomRepository.findAll().size());
		
		assertEquals("meetingroom",roomRepository.findOne(2).getType());
		
		roomRepository.delete(3);
		assertEquals(false,roomRepository.exists(3));
	}

	@Test
	public void TeacherTest(){
		teacherRepository.save(new Teacher(roomRepository.findOne(1),true));
		teacherRepository.save(new Teacher(roomRepository.findOne(2),false));
		teacherRepository.save(new Teacher(roomRepository.findOne(2),true));
		teacherRepository.save(new Teacher(roomRepository.findOne(2),true));
		teacherRepository.save(new Teacher(roomRepository.findOne(1),true));
		teacherRepository.save(new Teacher(roomRepository.findOne(1),false));
		
		assertEquals(6,teacherRepository.findAll().size());
		
		assertEquals(true, teacherRepository.findOne((long) 1).getGender());
		
		teacherRepository.delete((long) 1);
		
		assertEquals(false,teacherRepository.exists((long) 1));
	}
	
	@Test
	public void AdminClassTest(){
		adminClassRepository.save(new AdminClass(teacherRepository.findOne((long) 2),roomRepository.findOne(1),5));
		adminClassRepository.save(new AdminClass(teacherRepository.findOne((long) 3),roomRepository.findOne(2),4));

		assertEquals(2,adminClassRepository.findAll().size());

		assertEquals(5,adminClassRepository.findOne((long) 10).getGrade());
		
		adminClassRepository.delete((long)11);
		
		assertEquals(false,adminClassRepository.exists((long)11));
	}
	
	@Test
	public void StudentTest(){
		studentRepository.save(new Student(adminClassRepository.findOne((long) 10),virtualClassRepository.findOne((long) 2),true,new Date()));
		studentRepository.save(new Student(adminClassRepository.findOne((long) 10),virtualClassRepository.findOne((long) 3),false,new Date()));
		studentRepository.save(new Student(adminClassRepository.findOne((long) 10),virtualClassRepository.findOne((long) 2),true,new Date()));
		
		assertEquals(3,studentRepository.findAll().size());
		
		assertEquals(true,studentRepository.findOne((long) 7).getGender());
		
		studentRepository.delete((long) 9);
		
		assertEquals(false,studentRepository.exists((long) 9));
		
		
	}

	@Test
	public void SubjectTest(){
		subjectRepository.save(new Subject("English"));
		subjectRepository.save(new Subject("Chinese"));
		subjectRepository.save(new Subject("Math"));
		
		assertEquals(3,subjectRepository.findAll().size());
		
		assertEquals("English",subjectRepository.findOne(1).getTitle());
		
		subjectRepository.delete(3);
		
		assertEquals(false,subjectRepository.exists(3));
	}
	
    @Test
    public void PeriodTest(){
    	
    	periodRepository.save(new Period(1,new Time((new Date()).getTime()),new Time((new Date()).getTime())));
    	periodRepository.save(new Period(2,new Time((new Date()).getTime()),new Time((new Date()).getTime())));
    	periodRepository.save(new Period(3,new Time((new Date()).getTime()),new Time((new Date()).getTime())));
    	periodRepository.save(new Period(4,new Time((new Date()).getTime()),new Time((new Date()).getTime())));
    	periodRepository.save(new Period(5,new Time((new Date()).getTime()),new Time((new Date()).getTime())));
    	
    	assertEquals(5,periodRepository.findAll().size());
    	
    	assertEquals(3,periodRepository.findOne(3).getId());
    	
    	periodRepository.delete(5);
    	
    	assertEquals(false,periodRepository.exists(5));
    }
	
    @Test
    public void CourseTest(){
    	courseRepository.save(new Course((long)1,roomRepository.findOne(1),teacherRepository.findOne((long) 2),virtualClassRepository.findOne((long) 2),
    			                  subjectRepository.findOne(1),periodRepository.findOne(1),adminClassRepository.findOne((long) 10),1));
    }
=======
	@Autowired
	UserRepository ur;
	@Autowired
	RoleRepository rr;

	Role role = new Role(1, "admin");
	Date date = new Date();
//	User user = new User("root","root",rr.findOne(1),date,"sjw");
	@Test
	public void contextLoads() {
		Role role = new Role(1, "admin");
		rr.save(role);
	}
//		try{
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
//		Date date = sdf.parse("1996.06.22");} catch (ParseException e){System.out.println(e.getMessage());
//		Date date = new Date();
//		User user = new User(1l,"root","root",rr.findOne(1),date,"sjw");
//		ur.save(user);
//
//	@Test
//	public void contextLoads2() {
//
//		ur.save(user);
//	}
>>>>>>> origin/csy

}
