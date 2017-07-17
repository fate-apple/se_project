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
    private Date enroll_date;


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
    public Date getEnroll_date() {
        return enroll_date;
    }

    public void setEnroll_date(Date enroll_date) {
        this.enroll_date = enroll_date;
    }

    @Column(name="gender")
    public Boolean getGender() {
        return this.gender;
    }
    
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Student(AdminClass adminClass, VirtualClass virtualClass, Boolean gender, Date enroll_date) {

        this.adminClass = adminClass;
        this.virtualClass = virtualClass;
        this.gender = gender;
        this.enroll_date = enroll_date;
    }

    public Student(){
    };
}
