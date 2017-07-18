package com.se;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.dao.StudentRepository;
import com.se.dao.TakeRepository;
import com.se.domain.Student;
import com.se.domain.Take;

@Service
public class TestService {
	@Autowired
    private StudentRepository sr;
	@Autowired
    private TakeRepository tr;
    
    public TestService(StudentRepository sr, TakeRepository tr) {
		super();
		this.sr = sr;
		this.tr = tr;
	}

	public String TestData(){
    	Student student = sr.findOne(1);
    	List<Take> takes = student.getTakes();
    	if(takes.size()==4){return "ok!";}
    	else return "false";
    }

}
