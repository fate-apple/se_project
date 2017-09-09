package com.se.Controller;

import com.se.Domain.Business.Information;
import com.se.Service.Business.InformationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InformationController {
    @Autowired
    InformationService informationService;

    public String findFirst(Model model){
    return "";
    }
    
    @RequestMapping("/base/news")
    public String showNews(Model model){
    	List<Information> informations = informationService.findAll();
    	model.addAttribute("informations", informations);
    	return "base/news";
    }
}
