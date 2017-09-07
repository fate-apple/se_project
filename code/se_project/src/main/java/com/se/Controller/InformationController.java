package com.se.Controller;

import com.se.Service.Business.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class InformationController {
    @Autowired
    InformationService informationService;

    public String findFirst(Model model)

    }
}
