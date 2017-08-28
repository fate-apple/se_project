package com.se.Service.Business.Impl;

import com.se.Domain.Business.VirtualClass;
import com.se.Repository.Jpa.VirtualClassRepository;
import com.se.Service.Business.VirtualClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VirtualClassServiceImpl implements VirtualClassService{
    @Autowired
    VirtualClassRepository virtualClassRepository;

    @Override
    public List<VirtualClass> findAll(){
        return virtualClassRepository.findAll();
    }
}
