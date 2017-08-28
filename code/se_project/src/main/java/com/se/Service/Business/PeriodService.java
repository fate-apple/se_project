package com.se.Service.Business;

import com.se.Domain.Business.Period;

import java.util.Date;
import java.util.List;

public interface PeriodService {
    List<Period> findAll();

    Period findByDate(Date date);
}
