package com.se.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.se.domain.Student;



@Controller
@RequestMapping("/se")
public class IndexController {
	
	@RequestMapping("")
    public String index(Model model) {
    	List<Student> students =new ArrayList<Student>();
    	Student stu = new Student(1,"1234","sjw");
    	students.add(stu);
    	stu = new Student(2,"2222","lm");
    	students.add(stu);
        model.addAttribute("students",students );
        return "index";
    }
	
	@RequestMapping("/mg/stu")
    public String studentMangement(Model model) {
    	List<Student> students =new ArrayList<Student>();
    	Student stu = new Student(1,"1234","sjw");
    	students.add(stu);
    	stu = new Student(2,"2222","lm");
    	students.add(stu);
    	stu = new Student(3,"2322","lm");
    	students.add(stu);
    	stu = new Student(4,"22312","lm");
    	students.add(stu);
    	stu = new Student(5,"22321","lm");
    	students.add(stu);

        model.addAttribute("students",students );
        return "management/student";
    }
}