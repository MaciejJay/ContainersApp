package com.containers.controller;

import com.containers.model.User;
import com.containers.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/new")
    public ModelAndView addUser() {
        ModelAndView modelAndView = new ModelAndView("addNewUser");
        modelAndView.addObject("newUsers", new User());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update/{username}")
    public ModelAndView updateUserView(@PathVariable String username) {
        ModelAndView modelAndView = new ModelAndView("editUser");
        modelAndView.addObject("user", userService.findUserByUsername(username));
        modelAndView.addObject("newUpdate", true);
        return modelAndView;
    }

    @PostMapping("/user/update")
    public String usersUpdate(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/users" + user.getUsername();
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public ModelAndView findAllUsers() {
        Set<User> usersList = userService.findAllUser();
        ModelAndView modelAndView = new ModelAndView("usersList");
        modelAndView.addObject("listUsers", usersList);
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView userFindByUsername(@RequestParam String keyword) {
        ModelAndView modelAndView = new ModelAndView("searchUsers");
        Set<User> userSearch = userService.searchUsers(keyword);
        modelAndView.addObject("searchingUser", userSearch);
        return modelAndView;
    }
}
