package com.se.Service.Business.Impl;

import com.se.Domain.Business.AdminClass;
import com.se.Domain.Business.Information;
import com.se.Domain.Business.Pager;
import com.se.Domain.Business.User;
import com.se.Repository.Jpa.*;
import com.se.Service.Business.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    DisplayRepository displayRepository;
    @Autowired
    InformationRepository informationRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AdminClassRepository adminClassRepository;
    @Autowired
    StudentRepository studentRepository;
    @Override
    public List<Information> findAll() {
        GrantedAuthority[] authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray(new GrantedAuthority[0]);
        GrantedAuthority authority = authorities[0];
        String role = authority.getAuthority();
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (role.equals("ROLE_TEACHER"))return informationRepository.findByInformer(user);
        if (role.equals( "ROLE_CLASS")) return adminClassRepository.findByUsername(user.getUsername()).getReceived_information();
        if (role.equals(  "ROLE_STUDENT"))
            return studentRepository.findByUsername(user.getUsername()).getAdminClass().getReceived_information();
        return null;
    }
    @Override
    public Information findFirst(){
        List<Information>list = findAll();
        if(null!=list && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Information>findPage( Pager pager){
        List<Information>list =findAll();
        int start = (pager.getCurrentPage()-1)*pager.getPageSize();
        int end = pager.getCurrentPage()*pager.getPageSize();
        if(end<=list.size())return  list.subList(start,end);
        return null;
    }

    @Override
    public Information addInformation(String title, String content, String classes){
        String[] classesStr = classes.split(",");
        Set<AdminClass> receivers = new HashSet<AdminClass>();
        for (String classStr : classesStr) {
            receivers.add(adminClassRepository.findOne(Long.parseLong(classStr)));
        }
        User informer = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Information information = new Information(new java.sql.Date(System.currentTimeMillis()),title,content,informer,receivers);
        return informationRepository.save(information);

    }

}
