package com.se.Domain.Business;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Table(name="period")
@Entity
public class Period {
	
	private int id;	
	
	@NotEmpty	
	private Time beginTime;
	private Time endTime;
	
	protected Period(){
		
	}
	public Period(int id,  Time beginTime, Time endTime) {
		super();
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
}
