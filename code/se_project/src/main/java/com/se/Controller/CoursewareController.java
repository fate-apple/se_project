package com.se.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class CoursewareController {
	
    @RequestMapping("/edu/courseware")
    public String initCourseware(Model model) {
        return "edu/courseware";
    }
    
	  @RequestMapping("/edu/addcourseware")
	  public String addCourseware(@RequestParam MultipartFile file, Model model) {
		  System.out.println(file.getOriginalFilename());
	      return "edu/courseware";
	  }
}
