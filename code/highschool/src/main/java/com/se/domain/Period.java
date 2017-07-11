package com.se.domain;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="period")
@Entity
public class Period {
	@Id
	@Column(name="periodid")
	private int id;
	private int weekday;
	private Time beginTime;
	private Time endTime;
	
	protected Period(){
		
	}
	public Period(int id, int weekday, Time beginTime, Time endTime) {
		super();
		this.id = id;
		this.weekday = weekday;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWeekday() {
		return weekday;
	}
	public void setWeekday(int weekday) {
		this.weekday = weekday;
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
