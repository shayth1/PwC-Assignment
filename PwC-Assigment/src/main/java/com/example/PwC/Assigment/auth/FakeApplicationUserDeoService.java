package com.example.PwC.Assigment.auth;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import static com.example.PwC.Assigment.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDeoService implements ApplicationUserDeo {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDeoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicatonUsers().stream().filter(ApplicationUser -> username.equals(ApplicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicatonUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser("manager", passwordEncoder.encode("password"), MANAGER.getGrantedAuthorities(),
                        true, true, true, true),
                new ApplicationUser("employee", passwordEncoder.encode("password"), EMPLOYEE.getGrantedAuthorities(),
                        true, true, true, true),
                new ApplicationUser("viewer", passwordEncoder.encode("password"), VIEWER.getGrantedAuthorities(), true,
                        true, true, true)

        );

        return applicationUsers;
    }

}
