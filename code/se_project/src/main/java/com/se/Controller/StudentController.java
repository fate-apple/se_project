package com.se.Controller;

import com.se.Domain.Business.Student;
import com.se.Domain.Business.Teacher;
import com.se.Repository.Jpa.VirtualClassRepository;
import com.se.Service.Business.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    @Autowired
    private VirtualClassService virtualClassService;

    @RequestMapping("")
    public String manage(Model model) {
        model.addAttribute("adminClasses", adminClassService.findAll());
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("rooms", roomService.findAll());
        model.addAttribute("virtualClasses", virtualClassService.findAll());
        return "/manage/student";
    }

    @RequestMapping("/create")
    public ResponseEntity<?> create(@RequestParam String username, @RequestParam String password, @RequestParam String fullname,
                                    @RequestParam Long adminClassId, @RequestParam Long virtualClassId, @RequestParam Boolean gender, @RequestParam String enrollDate) {

        Student student = studentService.create(username, password, fullname, adminClassId, virtualClassId, gender, enrollDate);
        if (student == null) return ResponseEntity.badRequest().body("create error");
        return ResponseEntity.ok(student);
    }

    @RequestMapping("/update")
    public ResponseEntity<?> update(@RequestParam Long id, @RequestParam String username, @RequestParam String fullname,
                                    @RequestParam Long adminClassId, @RequestParam Long virtualClassId, @RequestParam Boolean gender, @RequestParam String enrollDate) {
        Student student = studentService.update(id, username, fullname, adminClassId, virtualClassId, gender, enrollDate);
        return ResponseEntity.ok(student);
    }

    @RequestMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        studentService.delete(id);
        return ResponseEntity.ok(null);
    }
}

