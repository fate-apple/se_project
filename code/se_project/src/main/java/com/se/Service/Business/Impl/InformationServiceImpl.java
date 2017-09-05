package com.se.Service.Business.Impl;

import com.se.Domain.Business.Display;
import com.se.Repository.Jpa.DisplayRepository;
import com.se.Repository.Jpa.InformationRepository;
import com.se.Service.Business.InformationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InformationServiceImpl implements InformationService {
    @Autowired
    DisplayRepository displayRepository;
    @Autowired
    InformationRepository informationRepository;
    @Override
    public List<Display> findAll(){
        return informationRepository.findAllOrderByDate();
    }
    @Override
    public Display findFirst(){
        List<Display>list = findAll();
        if(null!=list && list.size()>0){
            return list.get(1);
        }
        return null;
    }


}
