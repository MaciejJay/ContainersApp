package com.containers.controller;

import com.containers.model.User;
import com.containers.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/add")
    private String addNewUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    @PostMapping("/users/update")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/users" + user.getUsername();
    }

    @GetMapping("/users/delete/{username}")
    public String deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return "redirect:/users";
    }

    @GetMapping("/users/{username}")
    public ModelAndView findUserByUsername(@PathVariable String username) {
        ModelAndView modelAndView = new ModelAndView("userDetails");
        modelAndView.addObject("user", userService.findUserByUsername(username));
        return modelAndView;
    }
}
