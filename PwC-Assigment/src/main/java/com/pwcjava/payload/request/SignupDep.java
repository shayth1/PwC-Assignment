package com.pwcjava.payload.request;


import javax.validation.constraints.*;

public class SignupDep {
    @NotBlank
    @Size(min = 3, max = 20)
    private String dep_name;

    @NotBlank
    @Size(max = 50)
    @Email
    private String dep_email;


    private Long manager;


    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getDep_email() {
        return dep_email;
    }

    public void setDep_email(String dep_email) {
        this.dep_email = dep_email;
    }


    public Long getManager() {
        return manager;
    }

    public void setManager(Long manager) {
        this.manager = manager;
    }

}



