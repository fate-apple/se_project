package com.se.Domain.Business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se.Domain.Auth.Role;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Table(name = "adminclass")
@Entity
@PrimaryKeyJoinColumn(name = "class_id")
public class AdminClass extends User {

    private Teacher teacher;
    private Room room;
    private int grade;
    private transient Set<Student> students = new HashSet<Student>();
    private transient Set<Course> courses = new HashSet<Course>();

    public AdminClass() {
    }


    public AdminClass(Teacher teacher, Room room, int grade) {
        this.teacher = teacher;
        this.room = room;
        this.grade = grade;
    }

    public AdminClass(String username, String password, Role role, String fullname, Teacher teacher, Room room, int grade) {
        super(username, password, role, fullname);
        this.teacher = teacher;
        this.room = room;
        this.grade = grade;
    }

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
    @JsonIgnore
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Column(name = "grade")
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminClass")
    @JsonIgnore
    public Set<Student> getStudents() {
        return students;
    }


    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminClass")
    @JsonIgnore
    public Set<Course> getCourses() {
        return courses;
    }


    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }


}
