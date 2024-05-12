package com.skillstorm.services;

import com.skillstorm.dtos.UserDto;
import com.skillstorm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Add new User to DB:
    @Override
    public UserDto addUser(UserDto newUser) {
        return new UserDto(userRepository.saveAndFlush(newUser.map()));
    }

    // Find User by ID:
    @Override
    public UserDto findById(int id) {
        return new UserDto(userRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new));
    }

    // Update User by ID:
    @Override
    public UserDto updateById(int id, UserDto updatedUserInfo) {
        findById(id);
        updatedUserInfo.setId(id);
        return new UserDto(userRepository.saveAndFlush(updatedUserInfo.map()));
    }

    // Delete User by ID:
    @Override
    public void deleteById(int id) {
        findById(id);
        userRepository.deleteById(id);
    }
}
