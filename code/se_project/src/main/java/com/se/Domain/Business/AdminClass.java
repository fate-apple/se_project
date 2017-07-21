package com.se.Domain.Business;

<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se.Domain.Auth.Role;

>>>>>>> origin/csy
import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Table(name = "adminclass")
@Entity
@PrimaryKeyJoinColumn(name = "class_id") 
public class AdminClass extends User{

    private Teacher teacher;
    private Room room;
    private int grade;
<<<<<<< HEAD
    private Set<Student> students = new HashSet<Student>();
    private Set<Course> courses = new HashSet<Course>();
=======
    private transient Set<Student> students = new HashSet<Student>();
    private transient Set<Course> courses = new HashSet<Course>();
>>>>>>> origin/csy

    public AdminClass(){
    }


    public AdminClass(Teacher teacher, Room room, int grade) {
        this.teacher = teacher;
        this.room = room;
        this.grade = grade;
    }

<<<<<<< HEAD
=======
    public AdminClass(String username, String password, Role role, String fullname, Teacher teacher, Room room, int grade) {
        super(username, password, role, fullname);
        this.teacher = teacher;
        this.room = room;
        this.grade = grade;
    }

>>>>>>> origin/csy
    @OneToOne
    @JoinColumn(name = "class_teacher_id")
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @OneToOne
    @JoinColumn(name = "classroom_id")
<<<<<<< HEAD
=======
    @JsonIgnore
>>>>>>> origin/csy
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Column(name="grade")
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminClass")
<<<<<<< HEAD
=======
    @JsonIgnore
>>>>>>> origin/csy
	public Set<Student> getStudents() {
		return students;
	}


	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "adminClass")
<<<<<<< HEAD
=======
    @JsonIgnore
>>>>>>> origin/csy
	public Set<Course> getCourses() {
		return courses;
	}


	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}


}
