package com.se.Controller;

import com.se.Domain.Business.Teacher;
import com.se.Service.Business.AdminClassService;
import com.se.Service.Business.RoomService;
import com.se.Service.Business.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping("/create")
     public ResponseEntity<?> create(@RequestParam String username,@RequestParam String password,@RequestParam String fullname,@RequestParam int room_id,@RequestParam Boolean gender){
//        String username = httpServletRequest.getParameter("username");
//        String password = httpServletRequest.getParameter(("password"));
//        String fullname = httpServletRequest.getParameter("fullname");
//        int room_id = httpServletRequest.getParameter("room_id");
        Teacher teacher = teacherService.create(username, password, fullname, room_id, gender);
        if (teacher == null) return ResponseEntity.badRequest().body("create error");
        return ResponseEntity.ok(teacher);
    }
}
