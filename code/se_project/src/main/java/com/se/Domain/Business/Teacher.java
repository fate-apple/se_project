package com.se.Domain.Business;

<<<<<<< HEAD
import javax.persistence.*;

=======
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se.Domain.Auth.Role;

import javax.persistence.*;

import java.util.Date;
>>>>>>> origin/csy
import java.util.HashSet;
import java.util.Set;


@Table(name = "Teacher")
@Entity
@PrimaryKeyJoinColumn(name = "teacher_id") 
public class Teacher extends User{

    private Room room;
    private Boolean     gender;
    private Set<Course> courses = new HashSet<Course>();
    private AdminClass adminClass;
    
    public Teacher(){
    }
    
    public Teacher(Room room,Boolean gender){
		this.room = room;
		this.gender = gender;
    }
    
    @Column(name="gender")
    public Boolean getGender() {
        return this.gender;
    }
    
    public void setGender(Boolean gender) {
        this.gender = gender;
    }
    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher")
<<<<<<< HEAD
=======
    @JsonIgnore
>>>>>>> origin/csy
	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

    public Teacher(Room room) {
        this.room = room;
    }


    @ManyToOne
    @JoinColumn(name="office_id")
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

    @OneToOne(mappedBy="teacher")
<<<<<<< HEAD
=======
    @JsonIgnore
>>>>>>> origin/csy
	public AdminClass getAdminClass() {
		return adminClass;
	}

	public void setAdminClass(AdminClass adminClass) {
		this.adminClass = adminClass;
	}
<<<<<<< HEAD
    
=======

    public Teacher(String username, String password, Role role, String fullname, Room room, Boolean gender) {
        super(username, password, role, fullname);
        this.room = room;
        this.gender = gender;
    }
>>>>>>> origin/csy

}
