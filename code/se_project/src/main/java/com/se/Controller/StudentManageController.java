package com.se.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

<<<<<<< HEAD
=======
import com.se.Domain.Business.AdminClass;
import com.se.Repository.Jpa.VirtualClassRepository;
import com.se.Service.Business.AdminClassService;
import com.se.Service.Business.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> origin/csy
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
<<<<<<< HEAD
=======
	@Autowired
	StudentService studentService;
	@Autowired
	AdminClassService adminClassService;
	@Autowired
	VirtualClassRepository virtualClassRepository;
>>>>>>> origin/csy
	
	//根据所选的班级返回学生（不重复）
	@RequestMapping(value="/getStudent", method = RequestMethod.POST)
	public String getStudent(@RequestParam String classes,Model model){
<<<<<<< HEAD
		String[] classesStr = classes.split(",");
		System.out.println(classes);
		List<Student> students =new ArrayList<Student>();
		for (int i=0;i<classesStr.length;i++){
			//根据班级id查找每个班的学生
		}
		model.addAttribute("students",students );
=======

		List<Student> students =new ArrayList<Student>();
		students = studentService.findByAdminClasses(classes);

		model.addAttribute("students",students );
		model.addAttribute("adminClasses",adminClassService.findAll());
		model.addAttribute("virtualClasses",virtualClassRepository.findAll());

>>>>>>> origin/csy
		return "/manage/student";
	}
	
	//根据所选的年级，返回每个年级所有班级的名字和id
	@RequestMapping(value="/getClass", method = RequestMethod.POST)
	@ResponseBody
<<<<<<< HEAD
    public Map<String,Object> getClass(String grades) {
		String[] gradesStr = grades.split(",");
		Map<String,Object> classes = new HashMap<String,Object>();
		List<String> classname = new ArrayList<String> ();
		List<Integer> classid = new ArrayList<Integer> ();
		int classnum = 0;
		for (int i=0;i<gradesStr.length;i++){
			//根据年级返回每个年级的班级名字
			switch (gradesStr[i]){
			case "1":
				classname.add("高一（1）班");
				classid.add(1);
				classnum+=1;
				break;
			case "2":
				classname.add("高二（1）班");
				classid.add(5);
				classname.add("高二（2）班");
				classid.add(6);
				classnum+=2;
				break;
			case "3":
				classname.add("高三（1）班");
				classid.add(8);
				classnum+=1;
				break;
			case "0":
				classname.add("物化生（1）班");
				classid.add(10);
				classnum+=1;
				break;
			}		
		}
		classes.put("classname", classname);
		classes.put("classid", classid);
		classes.put("classnum",classnum);
		System.out.println(classes);
        return classes;
    }
	
=======
    public Map<String,Object> getClassByGrades(String grades) {
		Map<String,Object>classes = adminClassService.getClassByGrades(grades);
        return classes;
    }
>>>>>>> origin/csy

}
