package com.se.Service.Business;

import com.se.Domain.Business.AdminClass;
import com.se.Domain.Business.Information;
import com.se.Domain.Business.Pager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InformationService {




    List<Information> findAll();


    Information findFirst();

    List<Information>findPage(Pager pager);
}
