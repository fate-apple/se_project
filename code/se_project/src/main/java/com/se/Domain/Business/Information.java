package com.se.Domain.Business;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "information")
@Entity
public class Information {
	private int id;
	private Date date;
	private String title;
	private String content;
	private User informer;
	private Set<AdminClass> receivers = new HashSet<AdminClass>();

}
