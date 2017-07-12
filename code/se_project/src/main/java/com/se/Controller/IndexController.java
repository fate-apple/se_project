package com.se.Controller;

import com.se.Domain.Bussiness.User;
import com.se.Repository.Jpa.UserRepository;

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

UserRepository userRepository;


	@RequestMapping(value = "/test/all", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@RequestMapping("/login")
    public String index(Model model) {
    	List<Integer> classes =new ArrayList<Integer>();
    	classes.add(8);
    	classes.add(10);
    	classes.add(12);
        model.addAttribute("classes",classes );
        return "index";
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
	@RequestMapping("/main")
	String mai(){
		return"main";
	}
}