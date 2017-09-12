package com.se.Service.Business.Impl;

import com.se.Domain.Business.Courseware;
import com.se.Domain.Business.User;
import com.se.Repository.Jpa.AdminClassRepository;
import com.se.Repository.Jpa.CoursewareRepository;
import com.se.Repository.Jpa.StudentRepository;
import com.se.Repository.Jpa.UserRepository;
import com.se.Service.Business.CoursewareService;
import com.se.Service.Business.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@Service
public class CoursewareServiceImpl implements CoursewareService {
    @Autowired
    CoursewareRepository coursewareRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AdminClassRepository adminClassRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ProfileService profileService;

    @Override
    public Courseware UploadCourseware(MultipartFile file, String classes) throws IllegalStateException, IOException {
        return profileService.UploadCourseware(file,classes);
    }

    @Override
    public List<Courseware> findAll(){
        GrantedAuthority[] authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray(new GrantedAuthority[0]);
        GrantedAuthority authority = authorities[0];
        String role = authority.getAuthority();
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (role.equals("ROLE_TEACHER"))return coursewareRepository.findByUser(user);
        if (role.equals( "ROLE_CLASS")) return coursewareRepository.findByReceiversContaining(adminClassRepository.findByUsername(user.getUsername()));
        if (role.equals(  "ROLE_STUDENT"))
            return coursewareRepository.findByReceiversContaining( studentRepository.findByUsername(user.getUsername()).getAdminClass());
        return null;
    }
}
