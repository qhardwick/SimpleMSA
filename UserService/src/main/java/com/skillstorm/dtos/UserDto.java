package com.skillstorm.dtos;

import com.skillstorm.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    private int id;
    private String name;
    private String email;

    public UserDto(User user) {
        this.id = user.getId();;
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public User map() {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);

        return user;
    }
}
