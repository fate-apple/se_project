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
    
  //添加courseware，发布者后端获取，classes为接受者字符串需要处理一下
	  @RequestMapping("/edu/addcourseware")
	  public String addCourseware(@RequestParam MultipartFile file,@RequestParam String classes ,Model model) {
		  System.out.println(file.getOriginalFilename());
	      return "edu/courseware";
	  }
	  
	  @RequestMapping("base/courseware")
	  public String initDownload(Model model){
		  return "base/courseware";
	  }
}
