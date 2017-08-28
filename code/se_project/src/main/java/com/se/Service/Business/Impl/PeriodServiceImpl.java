package com.se.Service.Business.Impl;

import com.se.Domain.Business.Period;
import com.se.Repository.Jpa.PeriodRepository;
import com.se.Service.Business.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;
@Service
public class PeriodServiceImpl implements PeriodService {
    @Autowired
    PeriodRepository periodRepository;
    @Override
    public List<Period> findAll(){
        return periodRepository.findAll();
    }

    @Override
    public Period findByDate(Date utildate){
        Time date = new Time(utildate.getTime());
        List<Period> list = findAll();
        for(Period period : list){
            if(date.before(period.getEndTime())&&date.after(period.getEndTime())){
                return period;
            }
        }
        return null;
    }
}