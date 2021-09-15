package com.example.PwC.Assigment.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import static com.example.PwC.Assigment.security.ApplicationUserRole.*;
import static com.example.PwC.Assigment.security.ApplicationUserPermission.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(EMPLOYEE.name()).antMatchers(HttpMethod.DELETE, "/managment/api/**")
                .hasAuthority(DEPARTMENT_WRITE.name()).antMatchers(HttpMethod.POST, "/managment/api/**")
                .hasAuthority(DEPARTMENT_WRITE.name()).antMatchers(HttpMethod.PUT, "/managment/api/**")
                .hasAuthority(EMPLOYEE_WRITE.name()).antMatchers(HttpMethod.GET, "/managment/api/**")
                .hasAuthority(DEPARTMENT_WRITE.name()).antMatchers("/managment/api/**")
                .hasAnyRole(MANAGER.name(), VIEWER.name()).anyRequest().authenticated().and().httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        // user account Role
        UserDetails employeeUser = User.builder().username("user").password(passwordEncoder.encode("password"))
                .roles(EMPLOYEE.name()).build();

        // manager account Role

        UserDetails managerUser = User.builder().username("admin").password(passwordEncoder.encode("password"))
                .roles(MANAGER.name()).build();

        // Viewer Account Role
        UserDetails viewerUser = User.builder().username("viewer").password(passwordEncoder.encode("password"))
                .roles(VIEWER.name()).build();

        return new InMemoryUserDetailsManager(employeeUser, managerUser, viewerUser);
    }
}
