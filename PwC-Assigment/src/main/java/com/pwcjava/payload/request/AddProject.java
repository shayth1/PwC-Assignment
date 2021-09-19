package com.pwcjava.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AddProject {

    @NotBlank
    @Size(min = 3, max = 20)
    private String pro_name;


    private String pro_status;


    private Long manager;


    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_status() {
        return pro_status;
    }

    public void setPro_email(String pro_status) {
        this.pro_status = pro_status;
    }


    public Long getPManager() {
        return manager;
    }

    public void setManager(Long manager) {
        this.manager = manager;
    }
}
