package com.pwcjava.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long project_manager;


    private String project_name;


    private String project_status;





    public Project() {
    }

    public Project(Long project_manager, String project_name, String project_status) {
        this.project_manager = project_manager;
        this.project_name = project_name;
        this.project_status = project_status;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProM() {
        return project_manager;
    }

    public void setProM(Long project_manager) {this.project_manager= project_manager;}

    public String getProN() {
        return project_name;
    }
    public void setProN(String project_name) {this.project_name= project_name;}

    public String getProS() {
        return project_status;
    }

    public void setProS(String project_status) {
        this.project_status = project_status;
    }


}
