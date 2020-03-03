package com.containers.controller;

import com.containers.model.User;
import com.containers.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/add")
    public String addNewUser(Map<String, Object> map) {
            User newUser = new User();
            map.put("employee", newUser);
            return "addNewUser";
    }

    @PostMapping(value = "/users/add/save")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/";
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
    public ModelAndView usersFindByUsername() {
        List<User> usersList = userService.findAllUser();
        ModelAndView modelAndView = new ModelAndView("usersList");
        modelAndView.addObject("listUsers", usersList);
        return modelAndView;
    }
}
