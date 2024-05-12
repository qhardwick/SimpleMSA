package com.skillstorm.controllers;

import com.skillstorm.dtos.UserDto;
import com.skillstorm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Test endpoint:
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello UserController");
    }

    // Add new User:
    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto newUser) {
        UserDto createdUser = userService.addUser(newUser);
        return ResponseEntity.created(URI.create("/" + createdUser.getId())).body(createdUser);
    }

    // Find User by ID:
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") int id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    // Update User by ID:
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateById(@PathVariable("id") int id, @RequestBody UserDto updatedUserInfo) {
        return ResponseEntity.ok(userService.updateById(id, updatedUserInfo));
    }

    // Delete User by ID:
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") int id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
