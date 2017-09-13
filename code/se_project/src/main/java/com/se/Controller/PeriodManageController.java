package com.se.Controller;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.se.Domain.Business.Period;
import com.se.Repository.Jpa.PeriodRepository;


@Controller
@RequestMapping("/manage")
public class PeriodManageController {

    @Autowired
    private PeriodRepository periodRepository;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/getPeriod")
    public String getPeriod(Model model) {
        List<Period> periods = new ArrayList<Period>();
        periods = periodRepository.findAll();
        model.addAttribute("periods", periods);
        return "/manage/period";
    }

    //return message(add the case of "delete failed because of foreign key")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/deletePeriod")
    @ResponseBody
    public String deletePeriod(int periodId) {
        System.out.println(periodId);
        return "删除成功";
    }

    //add or update the period. If periodId==0 then add, else update
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/updatePeriod", method = RequestMethod.POST)
    public String updatePeriod(@RequestParam String beginTime,
                               @RequestParam String endTime, @RequestParam int periodId, Model model) {
        System.out.println(beginTime + endTime + periodId);
        List<Period> periods = new ArrayList<Period>();
        periods = periodRepository.findAll();
        model.addAttribute("periods", periods);
        return "redirect:/manage/getPeriod";
    }


}