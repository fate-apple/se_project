package com.example.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Brave on 16/10/9.
 */
/*就是@Controller+@ResponseBody组合，支持RESTful访问方式，返回结果都是json字符串*/
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

}
