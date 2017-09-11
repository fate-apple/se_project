package com.se.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.Domain.Business.Course;
import com.se.Service.Business.CourseSerivce;

@Controller
@RequestMapping("/manage/electivecourse")
public class ElectiveCourseController {
    //    @Autowired
//  CourseRepository courseRepository;
  @Autowired
  CourseSerivce courseSerivce;
//	@Autowired
//	private PeriodRepository periodRepository;

  @RequestMapping("")
  public String courseMangement(Model model) {
      return "manage/electivecourse";
  }
  
  @RequestMapping("/initselect")
  public String initSelect(Model model) {
      return "base/electivecourse";
  }
  
  @RequestMapping("/create")
  public ResponseEntity<?> create(@RequestParam int roomId, @RequestParam int capability,
                                  @RequestParam Long teacherId, @RequestParam int periodId, @RequestParam int subjectId, @RequestParam int weekday) {
      
      return ResponseEntity.ok(1);
  }

  @RequestMapping("/update")
  public ResponseEntity<?> update(@RequestParam Long courseId, @RequestParam int roomId, @RequestParam int capability,
                                  @RequestParam Long teacherId, @RequestParam int periodId, @RequestParam int subjectId, @RequestParam int weekday) {
      return ResponseEntity.ok(1);
  }

  @RequestMapping("/delete")
  public ResponseEntity<?> delete(@RequestParam Long courseId) {
      courseSerivce.delete(courseId);
      return ResponseEntity.ok(null);
  }
}
