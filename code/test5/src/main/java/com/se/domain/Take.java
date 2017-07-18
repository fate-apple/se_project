package com.se.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="take")
public class Take {

	private Integer take_id;
	private Student student;
	private String course_id;
	@Id
    @GeneratedValue
	public Integer getTake_id() {
		return take_id;
	}
	public void setTake_id(Integer take_id) {
		this.take_id = take_id;
	}
//	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.EAGER)
	@ManyToOne
    @JoinColumn(name = "id")
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	protected Take(){}
	
	
	
}
