package com.se.Domain.Business;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Document
public class Profile {
    public static final Integer TYPE_IMAGE = 0;
    public static final Integer TYPE_VIDEO = 1;
    public static final Integer TYPE_RTF = 2;

    private Integer userId;
    private Integer typeId;
    private String id;
    private String resource;
    private Date time;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String resourceId) {
        this.id = resourceId;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Date getTime() {
        return new Date(id);
    }

    public Profile(Integer userId, Integer typeId, String resource, Date time) {
        this.userId = userId;
        this.typeId = typeId;
        this.resource = resource;
        this.time = time;
    }
}

