package com.containers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

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

    @GetMapping("/email/send")
    public ModelAndView sendEmail() {
        return new ModelAndView("sendEmail");
    }

}
