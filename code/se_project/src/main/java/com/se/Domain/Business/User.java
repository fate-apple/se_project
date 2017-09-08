package com.se.Domain.Business;

import com.se.Domain.Auth.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by clevo on 2017/7/10.
 */
@Table(name = "User")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    private Long id;
    private String username;
    private String password;
    private Role role;
    private Date lastPasswordResetDate;
    private String fullname;
    private transient List<Information> informations = new ArrayList<>();
@OneToMany(mappedBy = "informer")
    public List<Information> getInformations() {
        return informations;
    }

    public void setInformations(List<Information> informations) {
        this.informations = informations;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

//    public User(String username, String password, Role role, Date lastPasswordResetDate, String fullname) {
//        this.username = username;
//        this.password = password;
//        this.role = role;
//        this.lastPasswordResetDate = lastPasswordResetDate;
//        this.fullname = fullname;
//    }


    public User(String username, String password, Role role, String fullname) {
        //this.id = id;
        this.username = username;
        this.password = password;
        this.lastPasswordResetDate = new Date();
        this.role = role;
        this.fullname = fullname;
    }

    protected User() {

    }
}
