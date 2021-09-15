package com.example.PwC.Assigment.users;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")

public class UserController {

    private static final List<User> USERS = Arrays.asList(new User(1, "shayth"), new User(2, "tamim"));

    @GetMapping(path = "{userId}")
    public User getUser(@PathVariable("userId") Integer userId) {

        return USERS.stream().filter(user -> userId.equals(user.getUserId())).findFirst()
                .orElseThrow(() -> new IllegalStateException("The user with id " + userId + " dose not exists"));
    }
}
