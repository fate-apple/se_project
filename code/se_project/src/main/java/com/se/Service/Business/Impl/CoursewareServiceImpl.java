package com.se.Service.Business.Impl;

import com.se.Domain.Business.Courseware;
import com.se.Repository.Jpa.CoursewareRepository;
import com.se.Service.Business.CoursewareService;
import com.se.Service.Business.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CoursewareServiceImpl implements CoursewareService {
    @Autowired
    CoursewareRepository coursewareRepository;
    @Autowired
    ProfileService profileService;

    @Override
    public Courseware UploadCourseware(MultipartFile file, String classes) throws IllegalStateException, IOException {
        return profileService.UploadCourseware(file,classes);
    }

}
