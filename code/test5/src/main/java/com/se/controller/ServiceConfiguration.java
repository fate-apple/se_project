package com.se.controller;

import javax.xml.ws.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.se.TestService;
import com.se.dao.StudentRepository;
import com.se.dao.TakeRepository;

@Configuration
@EnableConfigurationProperties(ServiceProperties.class)
public class ServiceConfiguration {
	
	@Bean
    public TestService service(ServiceProperties properties) {
        return new TestService(properties.getSr(),properties.getTr());
    }
}
