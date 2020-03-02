package com.containers.controller;

import com.containers.model.User;
import com.containers.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/add")
    public String addNewUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PostMapping("/users/update")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/users" + user.getUsername();
    }

    @GetMapping("/users/delete/")
    public String deleteUser(@RequestParam String username) {
        userService.deleteUser(username);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public ModelAndView usersFindByUsername(@RequestParam (required = false) String username) {
        ModelAndView modelAndView = new ModelAndView("userDetails");
        modelAndView.addObject("user", userService.findUserByUsername(username));
        return modelAndView;
    }
}
