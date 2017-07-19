package com.se.Domain.Business;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="student")
@PrimaryKeyJoinColumn(name = "student_id") 
public class Student extends User{
	
    private  AdminClass adminClass;
    private VirtualClass virtualClass;
    private Boolean     gender;
    private Date enrollDate;


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

    @Column(name="enroll_date")
    public Date getenrollDate() {
        return enrollDate;
    }

    public void setenrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    @Column(name="gender")
    public Boolean getGender() {
        return this.gender;
    }
    
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Student(AdminClass adminClass, VirtualClass virtualClass, Boolean gender, Date enrollDate) {

        this.adminClass = adminClass;
        this.virtualClass = virtualClass;
        this.gender = gender;
        this.enrollDate = enrollDate;
    }

    public Student(){
    };
}
