package com.se.Domain.Business;

public class Student{
	private int id;
	private String sno;
	private String name;
	
	public Student(int id ,String sno, String name){
		this.id = id;
		this.sno = sno;
		this.name =name;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}