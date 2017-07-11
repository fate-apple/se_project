package com.se.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by clevo on 2017/7/12.
 */
@Controller
@RequestMapping("/")
public class TestController {
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/manage/news")
    public String showNews(Model model) {
        return "management/news";
    }
}
