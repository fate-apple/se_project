package com.se.Service.Business;

import com.se.Domain.Business.AdminClass;
import com.se.Repository.Jpa.AdminClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by clevo on 2017/7/18.
 */
public interface AdminClassService {


    List<AdminClass> findAll();
}
