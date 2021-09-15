package com.example.PwC.Assigment.security;

public enum ApplicationUserPermission {
    EMPLOYEE_READ("employee:read"), EMPLOYEE_WRITE("employee:write"), DEPARTMENT_READ("department_read"),
    DEPARTMENT_WRITE("department_write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
