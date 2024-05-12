package com.skillstorm.services;

import com.skillstorm.dtos.UserDto;

public interface UserService {

    // Add new User to DB:
    UserDto addUser(UserDto newUser);

    // Find User by ID:
    UserDto findById(int id);

    // Update User by ID:
    UserDto updateById(int id, UserDto updatedUserInfo);

    // Delete User by ID:
    void deleteById(int id);
}
