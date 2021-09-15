package com.example.PwC.Assigment.auth;

import java.util.Optional;

public interface ApplicationUserDeo {

    public Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
