package com.se.Controller;

import com.se.Domain.Business.Information;
import com.se.Service.Business.InformationService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InformationController {
    @Autowired
    InformationService informationService;

    public String findFirst(Model model){
    return "";
    }
    
    @RequestMapping("/base/news")
    public String showNews(Model model){
    	List<Information> informations = new ArrayList<Information>();
    	informations = informationService.findAll();
    	model.addAttribute("informations", informations);
    	return "base/news";
    }
    
    //添加information，发布者后端获取，classes为接受者字符串需要处理一下
    @RequestMapping("/base/addnews")
    public String addNews(@RequestParam String title,@RequestParam String content,@RequestParam String classes){
    	System.out.println(title+content+classes);
    	return "base/news";
    }
}
