package com.containers.service;

import com.containers.exceptions.ContainerNotFoundException;
import com.containers.exceptions.UserNotFoundException;
import com.containers.model.Container;
import com.containers.model.User;
import com.containers.repository.UserRepository;
import org.springframework.data.jpa.repository.Query;
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
        Optional<User> userById = userRepository.findById(username);
        if (userById.isPresent()) {
            return userById.get();
        } else throw new UserNotFoundException("User not found");
    }

    public User updateUser(User user) {
        userRepository.deleteById(user.getUsername());
        return userRepository.save(user);
    }

    public List<User> searchUsers(String keyword) {
        return userRepository.search(keyword);
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    public User findById(String username) {
        return userRepository.findById(username).get();
    }
}