package com.crudproject.CRUD_Spring.controller;

import com.crudproject.CRUD_Spring.entity.Customer;
import com.crudproject.CRUD_Spring.entity.User;
import com.crudproject.CRUD_Spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class userController {

    private final UserService userService;

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        User existingUser = userService.loginUser(user.getEmail(), user.getPassword());

        if (existingUser != null) {
            return ResponseEntity.ok(existingUser); // return user details or token
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}
