package com.se.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.se.Domain.Business.Room;


@Controller
@RequestMapping("/manage")
public class RoomManageController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/getRoom")
    public String getStudent(Model model) {
//		Room room1 = new Room("1号楼","101",40,"教室");
//		Room room2 = new Room("3号楼","201",40,"办公室");
//		List<Room> rooms = new ArrayList<Room>();
//		rooms.add(room1);
//		rooms.add(room2);
//		model.addAttribute("rooms",rooms);
        return "/manage/room";
    }


}
