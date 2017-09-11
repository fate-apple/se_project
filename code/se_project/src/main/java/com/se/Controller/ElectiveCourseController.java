package com.se.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.Domain.Business.Course;
import com.se.Domain.Business.ElectiveCourse;
import com.se.Service.Business.CourseSerivce;
import com.se.Service.Business.ElectiveCourseService;

@Controller
@RequestMapping("/manage/electivecourse")
public class ElectiveCourseController {
    //    @Autowired
//  CourseRepository courseRepository;
  @Autowired
  ElectiveCourseService courseSerivce;
//	@Autowired
//	private PeriodRepository periodRepository;

  @RequestMapping("")
  public String courseMangement(Model model) {
	  List<ElectiveCourse> courses = courseSerivce.findAll();
	  model.addAttribute("courses",courses);
      return "manage/electivecourse";
  }
  
  @RequestMapping("/initselect")
  public String initSelect(Model model) {
	  List<ElectiveCourse> courses = courseSerivce.findAll();
	  model.addAttribute("courses",courses);
      return "base/electivecourse";
  }
  
  @RequestMapping("/create")
  public ResponseEntity<?> create(@RequestParam int roomId, @RequestParam int capability,
                                  @RequestParam Long teacherId, @RequestParam int periodId, @RequestParam int subjectId, @RequestParam int weekday) {
      ElectiveCourse course =  courseSerivce.create(roomId, null, null, teacherId, periodId, subjectId, weekday,capability);
      return ResponseEntity.ok(course);
  }

  @RequestMapping("/update")
  public ResponseEntity<?> update(@RequestParam Long courseId, @RequestParam int roomId, @RequestParam int capability,
                                  @RequestParam Long teacherId, @RequestParam int periodId, @RequestParam int subjectId, @RequestParam int weekday) {
	  ElectiveCourse course = (ElectiveCourse) courseSerivce.update(courseId, roomId, null, null, teacherId, periodId, subjectId, weekday, capability,0);
      return ResponseEntity.ok(course);
  }

  @RequestMapping("/delete")
  public ResponseEntity<?> delete(@RequestParam Long courseId) {
	  courseSerivce.delete(courseId);
      return ResponseEntity.ok(null);
  }
}
