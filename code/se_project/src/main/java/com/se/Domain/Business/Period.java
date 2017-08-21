package com.se.Domain.Business;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name="period")
@Entity
public class Period {
	
	private int id;	
	
	
	private Time beginTime;
	private Time endTime;
	private Set<Course> courses = new HashSet<Course>();


	public Period(){
		
	}
	public Period(int id,  Time beginTime, Time endTime) {
		this.id = id;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="period_id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
	public Time getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Time beginTime) {
		this.beginTime = beginTime;
	}
	
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "period")
	@JsonIgnore
	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
}
