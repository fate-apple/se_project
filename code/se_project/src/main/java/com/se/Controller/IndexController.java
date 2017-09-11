package com.se.Controller;

import com.se.Domain.Business.User;
import com.se.Repository.Jpa.UserRepository;

import com.se.Service.Auth.AuthService;
import com.se.Service.Business.AdminClassService;
import com.se.Service.Business.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    UserService userService;
    @Autowired
    AdminClassService adminClassService;
    @Autowired
    AuthService authService;


    @RequestMapping(value = "/test/all", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers() {
        return userService.findAll();
    }

    @RequestMapping("/register")
    public String register(Model model) {
        return "register";
    }

    @RequestMapping("/login")
    public String index(Model model) {
        //获取每个年级的班级数
        List<Integer> classes = new ArrayList<Integer>();
        classes.add(adminClassService.findByGrade(1).size());
        classes.add(adminClassService.findByGrade(2).size());
        classes.add(adminClassService.findByGrade(3).size());


        model.addAttribute("classes", classes);
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(Model model) {
        authService.logout();
        return "redirect:/login";
    }

    @RequestMapping("/manage/course")
    public String courseMangement(Model model) {
        return "manage/course";
    }

//    @RequestMapping("/display/class")
//    public String classDisplay(Model model) {
//        return "display/class";
//    }


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

//    @RequestMapping("/edu/courseware")
//    public String addCourseware(Model model) {
//        return "edu/courseware";
//    }


}