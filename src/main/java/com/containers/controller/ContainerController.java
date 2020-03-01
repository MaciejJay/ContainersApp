package com.containers.controller;

import com.containers.service.ContainerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContainerController {

    private ContainerService containerService;

    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @GetMapping("/")
    public ModelAndView getHomePage(){
        return new ModelAndView("index");
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }

    @GetMapping("/guest")
    public ModelAndView getGuestPage() {
        return new ModelAndView("guest");
    }

    @PostMapping("/menu")
    public ModelAndView getMenuPage() {
        return new ModelAndView("menu");
    }

    @GetMapping("/container/add")
    public ModelAndView addContainerPage() {
        return new ModelAndView("addNewContainer");
    }

    @GetMapping("/damages/history")
    public ModelAndView getDamagesHistory() {
        return new ModelAndView("damagesHistory");
    }

    @GetMapping("/container/status")
    public ModelAndView getDamageStatus() {
        return new ModelAndView("containerStatus");
    }

    @GetMapping("/email/send")
    public ModelAndView sendEmail() {
        return new ModelAndView("sendEmail");
    }

    @GetMapping("/users/search")
    public ModelAndView searchUsers() {
        return new ModelAndView("searchUsers");
    }

    @GetMapping("user/edit")
    public ModelAndView editUser(){
        return new ModelAndView("editUser");
    }

    @GetMapping("/container/add/model")
    public ModelAndView getContainerModelPage() {
        return new ModelAndView("containerModel");
    }

    @GetMapping("/container/find")
    public ModelAndView findContainer(@RequestParam String containerNo) {
        ModelAndView modelAndView = new ModelAndView("findContainer");
        modelAndView.addObject("findContainer", containerService.findContainerById(containerNo));
        return modelAndView;
    }
}
