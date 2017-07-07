package com.se.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.se.domain.Student;
import com.se.domain.User;
import com.se.security.JwtTokenHandler;
import com.se.service.UserService;
import com.se.service.impl.UserServiceImpl;



@Controller

public class IndexController {


	@Qualifier("userServiceImpl")
	private final UserService userService;
	private final JwtTokenHandler jwtTokenHandler;

	@Autowired
	public  IndexController(UserServiceImpl userService, JwtTokenHandler jwtTokenHandler) {
		this.userService = userService;
		this.jwtTokenHandler = jwtTokenHandler;
	}

	@RequestMapping(value = "/test/all", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers() {
		return userService.findAll();
	}
	@RequestMapping({"/","/login"})
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
	
	@RequestMapping("/test/news")
	String home(){
		return"management/news";
	}
}