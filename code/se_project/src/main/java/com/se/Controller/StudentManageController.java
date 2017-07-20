package com.se.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.se.Domain.Business.AdminClass;
import com.se.Service.Business.AdminClassService;
import com.se.Service.Business.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.se.Domain.Business.Student;

@Controller
@RequestMapping("/manage")
public class StudentManageController {
	@Autowired
	StudentService studentService;
	@Autowired
	AdminClassService adminClassService;
	
	//根据所选的班级返回学生（不重复）
	@RequestMapping(value="/getStudent", method = RequestMethod.POST)
	public String getStudent(@RequestParam String classes,Model model){

		List<Student> students =new ArrayList<Student>();
		students = studentService.findByAdminClasses(classes);

		model.addAttribute("students",students );
		return "/manage/student";
	}
	
	//根据所选的年级，返回每个年级所有班级的名字和id
	@RequestMapping(value="/getClass", method = RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> getClassByGrades(String grades) {
		Map<String,Object>classes = adminClassService.getClassByGrades(grades);
        return classes;
    }

}
