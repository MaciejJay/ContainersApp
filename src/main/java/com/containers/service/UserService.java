package com.containers.service;

import com.containers.exceptions.UserAlreadyExistException;
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

    public Set<User> findAllNonDeletedUser() {
        return userRepository.findUsersByWasReleasedFalse();
    }

    public Set<User> findDeletedUsers() {
        return userRepository.findUsersByWasReleasedTrue();
    }

    public User saveUser(User user) {
        if (!userRepository.existsById(user.getUsername())) {
            return userRepository.save(user);
        } else {
            throw new UserAlreadyExistException("User already exist");
        }
    }

    public Set<User> findUserByUsername(String username) {
        Optional<User> userById = userRepository.findById(username);
        if (userById.isPresent()) {
            Set<User> userSet = new HashSet<>();
            userSet.add(userById.get());
            return userSet;
        } else throw new UserNotFoundException("User not found");
    }

    public User findUserById(String username) {
        Optional<User> optionalUser = userRepository.findById(username);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else throw new UserNotFoundException("User not found");
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(String username) {
        userRepository.deleteUserFromPrimaryListAndAddUserToWasReleasedList(username);
    }
}