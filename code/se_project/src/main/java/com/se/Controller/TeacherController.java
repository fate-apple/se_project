package com.se.Controller;

import com.se.Service.Business.AdminClassService;
import com.se.Service.Business.RoomService;
import com.se.Service.Business.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by clevo on 2017/7/18.
 */
@Controller
@RequestMapping("/manage/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private RoomService roomService;

    @RequestMapping("")
    public String manage(Model model){
        model.addAttribute("teachers",teacherService.findAll());
        model.addAttribute("rooms",roomService.findAll());
        return "/manage/teacher";
    }

}
