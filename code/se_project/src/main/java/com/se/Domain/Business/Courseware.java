package com.se.Domain.Business;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="courseware")
@PrimaryKeyJoinColumn(name = "courseware_id",referencedColumnName = "profile_id")
public class Courseware extends  Profile{
    private String name;
    private Set<AdminClass> receivers;

    @ManyToMany( cascade= CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "courseware_receivers",
            joinColumns = {@JoinColumn(name = "profile_id", referencedColumnName = "profile_id")},
            inverseJoinColumns = {@JoinColumn(name = "class_id", referencedColumnName ="class_id")}
    )
    public Set<AdminClass> getReceivers() {
        return receivers;
    }

    public void setReceivers(Set<AdminClass> receivers) {
        this.receivers = receivers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Courseware(User user, Integer typeId, String resource, Date time, Display display, String name) {
        super(user, typeId, resource, time, display);
        this.name = name;
    }

    public Courseware(User user, Integer typeId, String resource, Date time, Display display, String name, Set<AdminClass> receivers) {
        super(user, typeId, resource, time, display);
        this.name = name;
        this.receivers = receivers;
    }

    public Courseware() {
    }
}
