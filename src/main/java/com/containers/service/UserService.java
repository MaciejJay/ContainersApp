package com.containers.service;

import com.containers.exceptions.UserNotFoundException;
import com.containers.model.User;
import com.containers.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser (User user){
        return userRepository.save(user);
    }

    public User getUserByUserName (String userName) {
        Optional<User> byUserName = userRepository.findByUserName(userName);

        if (byUserName.isPresent()) {
            return byUserName.get();
        } else throw new UserNotFoundException("User not found");
    }

    public User updateUser (User user) {
        userRepository.deleteById(user.getId());
        return userRepository.save(user);
    }

    public void deleteUser (Long id) {
        userRepository.deleteById(id);
    }
}