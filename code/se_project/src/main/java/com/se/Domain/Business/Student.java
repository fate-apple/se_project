package com.se.Domain.Business;

import com.se.Domain.Auth.Role;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "student_id")
@Access(AccessType.PROPERTY)
public class Student extends User {

    private AdminClass adminClass;
    private VirtualClass virtualClass;
    private Boolean gender;
    private Date enrollDate;

    private Set<ElectiveCourse> electiveCourses;

    public Student(String username, String password, Role role, String fullname, AdminClass adminClass, VirtualClass virtualClass, Boolean gender, Date enrollDate) {
        super(username, password, role, fullname);
        this.adminClass = adminClass;
        this.virtualClass = virtualClass;
        this.gender = gender;
        this.enrollDate = enrollDate;
    }


    @ManyToOne
    @JoinColumn(name = "class_id")
    public AdminClass getAdminClass() {
        return adminClass;
    }

    public void setAdminClass(AdminClass adminClass) {
        this.adminClass = adminClass;
    }

    @ManyToOne
    @JoinColumn(name = "virtual_class_id")
    public VirtualClass getVirtualClass() {
        return virtualClass;
    }

    public void setVirtualClass(VirtualClass virtualClass) {
        this.virtualClass = virtualClass;
    }

    @Column(name = "enroll_date")
    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    @Column(name = "gender")
    public Boolean getGender() {
        return this.gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
//    @ManyToMany(mappedBy = "students")
@ManyToMany(cascade = CascadeType.MERGE,targetEntity = ElectiveCourse.class)
@JoinTable(name = "takes",joinColumns = {@JoinColumn(name="student_id")},inverseJoinColumns = {@JoinColumn(name="course_id")})
//    @ManyToMany(cascade = CascadeType.MERGE,mappedBy = "students")
    public Set<ElectiveCourse> getElectiveCourses() {
        return electiveCourses;
    }

    public void setElectiveCourses(Set<ElectiveCourse> electiveCourses) {
        this.electiveCourses = electiveCourses;
    }

    public Student(AdminClass adminClass, VirtualClass virtualClass, Boolean gender, Date enrollDate) {

        this.adminClass = adminClass;
        this.virtualClass = virtualClass;
        this.gender = gender;
        this.enrollDate = enrollDate;
    }

    public Student() {
    }

    ;
}
