package com.se.Domain.Business;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="profile")
public class Profile {
    public static final Integer TYPE_IMAGE = 0;
    public static final Integer TYPE_VIDEO = 1;
    public static final Integer TYPE_RTF = 2;

    private User user;
    private Integer typeId;
    private int profile_id;
    private String resource;
    private Date time;
    private Display display;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "display_id")
    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }


    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Date getTime() {
        return new Date(System.currentTimeMillis());
    }

    public Profile(User user, Integer typeId, String resource, Date time,Display display) {
        this.user = user;
        this.typeId = typeId;
        this.resource = resource;
        this.time = time;
        this.display = display;

    }

    public Profile() {
    }
}

