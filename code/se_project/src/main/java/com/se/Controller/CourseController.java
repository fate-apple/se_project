package com.se.Controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.se.Domain.Business.Course;
import com.se.Domain.Business.Period;
import com.se.Domain.Business.Student;
import com.se.Domain.Business.Teacher;
import com.se.Repository.Jpa.CourseRepository;
import com.se.Repository.Jpa.PeriodRepository;
import com.se.Repository.Jpa.StudentRepository;
import com.se.Service.Business.CourseSerivce;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * Created by clevo on 2017/7/20.
 */
@Controller
@RequestMapping("/manage/course")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class CourseController {
    //    @Autowired
//    CourseRepository courseRepository;
    @Autowired
    CourseSerivce courseSerivce;
//	@Autowired
//	private PeriodRepository periodRepository;

    @RequestMapping("/create")
    public ResponseEntity<?> create(@RequestParam int roomId, @RequestParam(value = "adminClassId", required = false) Long adminClassId, @RequestParam(value = "virtualClassId", required = false) Long virtualClassId,
                                    @RequestParam Long teacherId, @RequestParam int periodId, @RequestParam int subjectId, @RequestParam int weekday) {
        Course course = courseSerivce.create(roomId, adminClassId, virtualClassId, teacherId, periodId, subjectId, weekday);
        return ResponseEntity.ok(course);
    }

    @RequestMapping("/update")
    public ResponseEntity<?> update(@RequestParam Long courseId, @RequestParam int roomId, @RequestParam Long adminClassId, @RequestParam Long virtualClassId,
                                    @RequestParam Long teacherId, @RequestParam int periodId, @RequestParam int subjectId, @RequestParam int weekday) {
        Course course = courseSerivce.update(courseId, roomId, adminClassId, virtualClassId, teacherId, periodId, subjectId, weekday);
        return ResponseEntity.ok(course);
    }

    @RequestMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long courseId) {
        courseSerivce.delete(courseId);
        return ResponseEntity.ok(null);
    }

    @RequestMapping("/findByAdminClass")
    public String findByAdminClasses(@RequestParam String adminClasses, Model model) {
        List<Course> courseList = courseSerivce.findByAdminClasses(adminClasses);
        model.addAttribute("courses", courseList);
        return "manage/course";
    }


    @RequestMapping("/findByUsername")
    public ResponseEntity<?> findByStudent(@RequestParam String username, Model model) {
        List<Course> courseList = courseSerivce.findByStudentname(username);
        model.addAttribute("courses", courseList);
        return ResponseEntity.ok(courseList);
    }

}
