package com.containers.service;

import com.containers.exceptions.UserNotFoundException;
import com.containers.model.User;
import com.containers.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserByUsername(String username) {
        Optional<User> byUsername = userRepository.findById(username);

        if (byUsername.isPresent()) {
            return byUsername.get();
        } else throw new UserNotFoundException("User " + username + " not found");
    }

    public User updateUser(User user) {
        userRepository.deleteById(user.getUsername());
        return userRepository.save(user);
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }
}