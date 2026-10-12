package com.BankingSystem.bankingsystem.controller;

import org.springframework.web.bind.annotation.*;

import com.BankingSystem.bankingsystem.model.User;
import com.BankingSystem.bankingsystem.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // Spring will inject UserService here
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // MENU OPTION: Create User
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user.getName(), user.getEmail());
    }
}
