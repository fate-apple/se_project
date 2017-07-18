package com.se;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.se.dao.StudentRepository;
import com.se.dao.TakeRepository;
import com.se.domain.Student;
import com.se.domain.Take;


@RestController
@EnableAutoConfiguration
public class TestController {
	
	@Autowired
    private StudentRepository sr;
	@Autowired
    private TakeRepository tr;
	@RequestMapping("/")
    public @ResponseBody String test() {
		Student student = sr.findOne(1);
    	List<Take> takes = student.getTakes();
    	if(takes.size()==4){return "ok!";}
    	else return "false";
    }
	 public static void main(String[] args) throws Exception {
	        SpringApplication.run(TestController.class, args);
	    }
	
}
