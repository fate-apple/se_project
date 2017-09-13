package com.se.Domain.Business;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name="electiveCourse")
@Entity
@PrimaryKeyJoinColumn(name = "course_id")
@Access(AccessType.PROPERTY)
public class ElectiveCourse extends  Course {
    private int capability;
    private int number;

   private List<Student> students=new ArrayList<>();

    public ElectiveCourse() {
    }

    public ElectiveCourse(Room room, Teacher teacher, VirtualClass virtualClass, Subject subject, Period period, AdminClass adminClass, Integer weekday, int capability, int number) {
        super(room, teacher, virtualClass, subject, period, adminClass, weekday);
        this.capability = capability;
        this.number = number;
    }



    public int getCapability() {
        return capability;
    }

    public void setCapability(int capability) {
        this.capability = capability;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    @ManyToMany(cascade = CascadeType.MERGE,targetEntity = Student.class)
    @JoinTable(name = "takes",joinColumns = {@JoinColumn(name="course_id",referencedColumnName = "course_id")},inverseJoinColumns = {@JoinColumn(name="student_id",referencedColumnName = "student_id")})
    @JsonIgnore
    public List<Student> getStudents() {
        return students;
    }
//    @ManyToMany(cascade = CascadeType.MERGE,mappedBy = "electiveCourses")
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
