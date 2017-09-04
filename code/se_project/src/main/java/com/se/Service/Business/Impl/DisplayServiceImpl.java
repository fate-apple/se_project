package com.se.Service.Business.Impl;

import com.se.Domain.Business.AdminClass;
import com.se.Domain.Business.Display;
import com.se.Domain.Business.User;
import com.se.Repository.Jpa.AdminClassRepository;
import com.se.Repository.Jpa.DisplayRepository;
import com.se.Repository.Jpa.UserRepository;
import com.se.Service.Business.DisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class DisplayServiceImpl implements DisplayService {
    @Autowired
    DisplayRepository displayRepository;
    @Autowired
    AdminClassRepository adminClassRepository;
    public Display findDisplay(){
        try{
            AdminClass adminClass= adminClassRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
            Display display = displayRepository.findByRoomId(adminClass.getRoom().getRoomId());
            return display;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    
}
