package com.se;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SeProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeProjectApplication.class, args);
    }
    
//    /**
//     * 文件上传临时路径
//     */
//     @Bean
//     MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setLocation("/");
//        return factory.createMultipartConfig();
//    }
}
