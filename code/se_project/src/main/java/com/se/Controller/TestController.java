//package com.se.Controller;
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// * Created by clevo on 2017/7/12.
// */
//@Controller
//@RequestMapping("/")
//public class TestController {
//    @RequestMapping({"/","/index"})
//    public String index(Model model){
//        return  "/index";
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @RequestMapping("/manage/news")
//    public String showNews(Model model) {
//        return "management/news";
//    }
//
//    @PreAuthorize("hasRole('USER')")
//    @RequestMapping("/cd")
//    public String classDisplay(Model model) {
//        return "display/classDisplay";
//    }
//}
