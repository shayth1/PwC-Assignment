package com.pwcjava.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "departments")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String dep_name;

    @NotBlank
    @Size(max = 50)
    @Email
    private String dep_email;


    private Long manager;


    public Departments() {
    }

    public Departments(String dep_name, String dep_email,  Long manager) {
        this.dep_name = dep_name;
        this.dep_email = dep_email;
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepname() {
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

    public void setManager(Long department) {this.manager= manager;}

}
