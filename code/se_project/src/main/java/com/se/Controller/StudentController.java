package com.se.Controller;

import com.se.Service.Business.AdminClassService;
import com.se.Service.Business.RoomService;
import com.se.Service.Business.StudentService;
import com.se.Service.Business.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by clevo on 2017/7/18.
 */
@Controller
@RequestMapping("/manage/student")
public class StudentController {
    @Autowired
    private AdminClassService adminClassService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private StudentService studentService;

    @RequestMapping("")
    public String manage(Model model){
        model.addAttribute("classes",adminClassService.findAll());
        model.addAttribute("teachers",teacherService.findAll());
        model.addAttribute("rooms",roomService.findAll());
        model.addAttribute("students",studentService.findAll());
        return "/manage/student";
    }


//    @RequestMapping("/create")
//    public ResponseEntity<?> create(@RequestParam String username,@RequestParam String password,@RequestParam String fullname,@)

}

