package com.se.Controller;

import com.se.Domain.Business.Courseware;
import com.se.Service.Business.CoursewareService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/")
public class CoursewareController {
	@Autowired
	CoursewareService coursewareService;
	
    @RequestMapping("/edu/courseware")
    public String initCourseware(Model model) {
//        model.addAttribute("coursewares",coursewareService.findAll());
    	return "edu/courseware";
    }
    
  //添加courseware，发布者后端获取，classes为接受者字符串需要处理一下
	  @RequestMapping("/edu/addcourseware")
	  public String addCourseware(@RequestParam MultipartFile file,@RequestParam String classes ,Model model) throws  Exception {
			coursewareService.UploadCourseware(file,classes);
		  System.out.println(file.getOriginalFilename());
	      return "edu/courseware";
	  }
	  
	  @RequestMapping("base/courseware")
	  public String initDownload(Model model){
		  List<Courseware> coursewares = coursewareService.findAll();
		  model.addAttribute("coursewares",coursewares);
    	return "base/courseware";
	  }
	  
	  @RequestMapping("base/courseware/download")
	  public String download(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam int id, Model model) throws Exception{
		  System.out.println(id);
		 Courseware courseware = coursewareService.download(httpServletRequest,httpServletResponse,id);
		  model.addAttribute("courseware",courseware);
    	return "base/courseware";
	  }
}
