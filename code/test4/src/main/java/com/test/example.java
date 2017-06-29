package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@EnableAutoConfiguration
public class example {
	
	@Autowired
	private CityRepository cr;
	
	@RequestMapping("/")
	long count(){
		String city = "beijin";
		return cr.findByNameAndStateAllIgnoringCase(city, "china").getId();
	}
	 public static void main(String[] args) throws Exception {
	        SpringApplication.run(example.class, args);
	    }
}
