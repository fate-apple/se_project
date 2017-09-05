package com.se.Service.Business;

import com.se.Domain.Business.Display;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InformationService {
    List<Display> findAll();

    Display findFirst();
}
