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
    	List<Integer> classes =new ArrayList<Integer>();
    	classes.add(8);
    	classes.add(10);
    	classes.add(12);
    	
        model.addAttribute("classes",classes );
        return "index";
    }
	
	@RequestMapping("/manage/stu")
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
	
	@RequestMapping("/cd")
    public String classDisplay(Model model) {
        return "display/classDisplay";
    }
	
	@RequestMapping("/manage/news")
    public String showNews(Model model) {
        return "management/news";
    }
	
	@RequestMapping("/manage/addnews")
    public String addNews(Model model) {
        return "management/addnews";
    }
	
	@RequestMapping("/manage/timetable")
    public String showTimetable(Model model) {
        return "management/timetable";
    }
}