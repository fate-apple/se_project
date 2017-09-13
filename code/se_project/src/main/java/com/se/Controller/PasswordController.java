package com.se.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PasswordController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/manage/password")
	public String resetPassword(Model model){
		return "/manage/password";
	}
	
	@RequestMapping(value="/base/password")
	public String modifyPassword(Model model){
		return "/base/password";
	}
}
