package com.se.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.se.domain.Student;



@Controller
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
	
	@RequestMapping("/manage/student")
    public String studentMangement(Model model) {
        return "manage/student";
    }
	
	@RequestMapping("/manage/room")
    public String roomMangement(Model model) {
        return "manage/room";
    }
	
	@RequestMapping("/display/class")
    public String classDisplay(Model model) {
        return "display/class";
    }
	
	@RequestMapping("/base/news")
    public String showNews(Model model) {
        return "base/news";
    }
	
	@RequestMapping("/edu/addnews")
    public String addNews(Model model) {
        return "edu/addnews";
    }
	
//	@RequestMapping("/base/timetable")
//    public String showTimetable(Model model) {
//        return "base/timetable";
//    }
	
	@RequestMapping("/edu/courseware")
    public String addCourseware(Model model) {
        return "edu/courseware";
    }
}