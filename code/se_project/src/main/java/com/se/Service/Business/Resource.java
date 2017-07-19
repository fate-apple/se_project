package com.se.Service.Business;

import org.springframework.stereotype.Component;

/**
 * Created by clevo on 2017/7/18.
 */
@Component
public class Resource {
    private Object o;
    private  boolean success;
    private String message;

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
