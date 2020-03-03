package com.containers.service;

import com.containers.exceptions.UserNotFoundException;
import com.containers.model.User;
import com.containers.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Set<User> findAllUser() {
        return new HashSet<>(userRepository.findAll());
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserByUsername(String username) {
        Optional<User> userById = userRepository.findById(username);
        if (userById.isPresent()) {
            return userById.get();
        } else throw new UserNotFoundException("User not found");
    }

    public User updateUser(User user) {
        userRepository.deleteById(user.getUsername());
        return userRepository.save(user);
    }

    public Set<User> searchUsers(String keyword) {
        return new HashSet<>(userRepository.search(keyword));
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    public User findById(String username) {
        return userRepository.findById(username).get();
    }
}