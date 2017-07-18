package com.se.Service.Business.Impl;

import com.se.Domain.Business.AdminClass;
import com.se.Repository.Jpa.AdminClassRepository;
import com.se.Service.Business.AdminClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by clevo on 2017/7/18.
 */
@Service
public class AdminClassServiceImpl implements AdminClassService{
    @Autowired
    private AdminClassRepository adminClassRepository;

    @Override
    public List<AdminClass> findAll(){
        return adminClassRepository.findAll();
    }
}
