package com.se.Controller;

import java.util.ArrayList;
import java.util.List;

import com.se.Service.Business.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.Domain.Business.Period;
import com.se.Repository.Jpa.PeriodRepository;


@Controller
@RequestMapping("/base/timetable")
public class TimetableController {
    @Autowired
    private PeriodService periodService;

    @RequestMapping(value = "")
    public String getPeriod(Model model) {
        List<Period> periods = new ArrayList<Period>();
        periods = periodService.findAll();
        model.addAttribute("periods", periods);
        return "/base/timetable";
    }

}