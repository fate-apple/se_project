package com.se.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.domain.Period;
import com.se.domain.Room;
import com.se.repository.PeriodRepository;

@Controller
@RequestMapping("/manage")
public class PeriodManageController {
	
	@Autowired
	private PeriodRepository periodRepository;
	
	@RequestMapping(value="/getPeriod")
	public String getPeriod(Model model){
		List<Period> periods = new ArrayList<Period>();
		periods = periodRepository.findAll();
		model.addAttribute("periods", periods);
		return "/manage/period";
	}
	
	


}