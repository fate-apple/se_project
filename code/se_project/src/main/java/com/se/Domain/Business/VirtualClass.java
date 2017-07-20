package com.se.Domain.Business;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;


@Table(name = "virtualclass")
@Entity
public class VirtualClass {
    private Long virtualClassId;
    private String name;
    private transient Set<Course> courses = new HashSet<Course>();
	private transient Set<Student> students = new HashSet<Student>();

    public VirtualClass(Long virtualClassId, String name) {

        this.virtualClassId = virtualClassId;
        this.name = name;
    }
    public VirtualClass(){
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getVirtualClassId() {
        return virtualClassId;
    }

    public void setVirtualClassId(Long virtualClassId) {
        this.virtualClassId = virtualClassId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "virtualClass")
    @JsonIgnore
	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "virtualClass")
    @JsonIgnore
	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
