package com.containers.controller;

import com.containers.model.User;
import com.containers.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public ModelAndView addUser() {
        ModelAndView modelAndView = new ModelAndView("addNewUser");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("update", false);
        return modelAndView;
    }

    @PostMapping("/add")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update/{username}")
    public ModelAndView updateUserView(@PathVariable String username) {
        ModelAndView modelAndView = new ModelAndView("addNewUser");
        modelAndView.addObject(userService.findUserById(username));
        modelAndView.addObject("update", true);
        return modelAndView;
    }

    @PostMapping("/update")
    public String usersUpdate(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return "redirect:/users";
    }

    @GetMapping("")
    public ModelAndView findAllUsers(@RequestParam(required = false) String username) {
        ModelAndView modelAndView = new ModelAndView("usersList");
        if (username == null) {
            return modelAndView.addObject("listUsers", userService.findAllNonDeletedUser());
        } else
            return modelAndView.addObject("listUsers", userService.findUserByUsername(username.trim()));
    }

    @GetMapping("/deleted")
    public ModelAndView findAllDeletedUsers() {
        ModelAndView modelAndView = new ModelAndView("listNonActiveUsers");
        return modelAndView.addObject("listDeleted", userService.findDeletedUsers());
    }
}
