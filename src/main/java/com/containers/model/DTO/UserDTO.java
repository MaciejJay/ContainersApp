package com.containers.model.DTO;

import com.containers.model.User;
import lombok.Data;

@Data
public class UserDTO extends User {
    private String firstName;
    private String lastName;

    public UserDTO(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }
}
