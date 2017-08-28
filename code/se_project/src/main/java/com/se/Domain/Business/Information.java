package com.se.Domain.Business;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Information {
	private Date date;
	private String title;
	private String content;
	private User informer;
	private Set<AdminClass> receivers = new HashSet<AdminClass>(); 
	
}
