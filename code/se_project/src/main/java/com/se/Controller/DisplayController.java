package com.se.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.Domain.Business.Period;
import com.se.Repository.Jpa.PeriodRepository;

@Controller
@RequestMapping("/")
public class DisplayController {
	@Autowired
	private PeriodRepository periodRepository;
	
	@RequestMapping(value="/display/class")
	public String initDisplay(Model model){
		List<Period> periods = new ArrayList<Period>();
		periods = periodRepository.findAll();
		model.addAttribute("periods", periods);
		return "/display/class";
	}
}
