package com.se.Service.Business.Impl;

import com.se.Repository.Jpa.CoursewareRepository;
import com.se.Service.Business.CoursewareService;
import org.springframework.beans.factory.annotation.Autowired;

public class CoursewareServiceImpl implements CoursewareService {
    @Autowired
    CoursewareRepository coursewareRepository;


}
