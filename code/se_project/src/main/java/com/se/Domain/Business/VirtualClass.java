package com.se.Domain.Business;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Table(name = "virtualclass")
@Entity
public class VirtualClass {
    private Long virtual_class_id;
    private String name;
    private Set<Course> courses = new HashSet<Course>();
	private Set<Student> students = new HashSet<Student>();

    public VirtualClass(Long virtual_class_id, String name) {

        this.virtual_class_id = virtual_class_id;
        this.name = name;
    }
    public VirtualClass(){
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getVirtual_class_id() {
        return virtual_class_id;
    }

    public void setVirtual_class_id(Long virtual_class_id) {
        this.virtual_class_id = virtual_class_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "virtualClass")
	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "virtualClass")
	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
