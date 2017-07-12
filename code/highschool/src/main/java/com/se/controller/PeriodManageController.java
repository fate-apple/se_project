package com.se.controller;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value="/updatePeriod",method = RequestMethod.POST)
	public String updatePeriod(@RequestParam int weekday,@RequestParam String beginTime,
			 @RequestParam String endTime,Model model){
		System.out.println(weekday+beginTime+endTime);
		List<Period> periods = new ArrayList<Period>();
		periods = periodRepository.findAll();
		model.addAttribute("periods", periods);
		return "redirect:/manage/getPeriod";
	}
	
	


}