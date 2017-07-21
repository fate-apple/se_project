package com.se.Domain.Business;

<<<<<<< HEAD
=======
import com.se.Domain.Auth.Role;

>>>>>>> origin/csy
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="student")
@PrimaryKeyJoinColumn(name = "student_id") 
public class Student extends User{
	
<<<<<<< HEAD
    private AdminClass adminClass;
    private VirtualClass virtualClass;
    private Boolean     gender;
    private Date enroll_date;
=======
    private  AdminClass adminClass;
    private VirtualClass virtualClass;
    private Boolean     gender;
    private Date enrollDate;

    public Student(String username, String password, Role role, String fullname, AdminClass adminClass, VirtualClass virtualClass, Boolean gender, Date enrollDate) {
        super(username, password, role, fullname);
        this.adminClass = adminClass;
        this.virtualClass = virtualClass;
        this.gender = gender;
        this.enrollDate = enrollDate;
    }
>>>>>>> origin/csy


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
<<<<<<< HEAD
    public Date getEnroll_date() {
        return enroll_date;
    }

    public void setEnroll_date(Date enroll_date) {
        this.enroll_date = enroll_date;
=======
    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
>>>>>>> origin/csy
    }

    @Column(name="gender")
    public Boolean getGender() {
        return this.gender;
    }
    
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

<<<<<<< HEAD
    public Student(AdminClass adminClass, VirtualClass virtualClass, Boolean gender, Date enroll_date) {
=======
    public Student(AdminClass adminClass, VirtualClass virtualClass, Boolean gender, Date enrollDate) {
>>>>>>> origin/csy

        this.adminClass = adminClass;
        this.virtualClass = virtualClass;
        this.gender = gender;
<<<<<<< HEAD
        this.enroll_date = enroll_date;
=======
        this.enrollDate = enrollDate;
>>>>>>> origin/csy
    }

    public Student(){
    };
}
