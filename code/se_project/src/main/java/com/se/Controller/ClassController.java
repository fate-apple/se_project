package com.se.Controller;

import com.se.Domain.Business.AdminClass;
import com.se.Domain.Business.Student;
import com.se.Domain.Business.Teacher;
import com.se.Service.Business.AdminClassService;
import com.se.Service.Business.RoomService;
import com.se.Service.Business.TeacherService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by clevo on 2017/7/18.
 */
@PreAuthorize("isAuthenticated()")
@Controller
@RequestMapping("/manage/class")
public class ClassController {
    @Autowired
    private AdminClassService adminClassService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private RoomService roomService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("")
    public String manage(Model model) {
        model.addAttribute("classes", adminClassService.findAll());
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("rooms", roomService.findAll());
        return "/manage/class";
    }
@PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/create")
    public ResponseEntity<?> create(@RequestParam String username, @RequestParam String password, @RequestParam String fullname, @RequestParam Long teacherId, @RequestParam int roomId, @RequestParam int grade) {

        AdminClass adminClass = adminClassService.create(username, password, fullname, teacherId, roomId, grade);
        if (adminClass == null) return ResponseEntity.badRequest().body("create error");
        return ResponseEntity.ok(adminClass);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/update")
    public ResponseEntity<?> update(@RequestParam Long id, @RequestParam String username, @RequestParam String fullname, @RequestParam Long teacherId, @RequestParam int roomId, @RequestParam int grade) {
        AdminClass adminClass = adminClassService.update(id, username, fullname, teacherId, roomId, grade);
        return ResponseEntity.ok(adminClass);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        adminClassService.delete(id);
        return ResponseEntity.ok(null);
    }

}
