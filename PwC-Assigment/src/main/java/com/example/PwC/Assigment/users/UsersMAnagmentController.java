package com.example.PwC.Assigment.users;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("managment/api/v1/users")

public class UsersMAnagmentController {

    private static final List<User> USERS = Arrays.asList(new User(1, "shayth"), new User(2, "tamim"),
            new User(3, "saif"));

    @GetMapping
    public List<User> getAllUsers() {
        return USERS;
    }

    @PostMapping
    public void registerNewEmployee(@RequestBody User user) {
        System.out.println(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteEmployee(Integer userId) {
        System.out.println(userId);
    }

    public void updateUser(Integer userId, User user) {
        System.out.println(String.format("%s %s", userId, user));

    }

}
