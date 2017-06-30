package com.se.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.se.dao.StudentRepository;
import com.se.dao.TakeRepository;

@ConfigurationProperties("controller")
public class ServiceProperties {
    private StudentRepository sr;
    private TakeRepository tr;
	public StudentRepository getSr() {
		return sr;
	}
	public void setSr(StudentRepository sr) {
		this.sr = sr;
	}
	public TakeRepository getTr() {
		return tr;
	}
	public void setTr(TakeRepository tr) {
		this.tr = tr;
	}
}
