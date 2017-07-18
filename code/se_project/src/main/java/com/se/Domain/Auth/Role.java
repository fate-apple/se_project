package com.se.Domain.Auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
<<<<<<< HEAD
import com.se.Domain.Bussiness.User;
=======
import com.se.Domain.Business.User;
>>>>>>> cf14035ebec2295d395762a50c1696656ddd5378

import javax.persistence.*;
import java.util.List;

/**
 * Created by clevo on 2017/7/10.
 */
@Table(name="Role")
@Entity
public class Role {
    private int role_id;
    private String rolename;
    transient private List<User> users;

    public Role(int id, String roleName) {
        this.role_id = id;
        this.rolename = roleName;
    }

    @Id
    @Column(name = "role_id")
    public int getId() {

        return role_id;
    }

    public void setId(int id) {
        this.role_id = id;
    }
    @Column(name="rolename")
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }



    @OneToMany(mappedBy = "role")
    @JsonIgnore
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    protected Role(){

    }
}
