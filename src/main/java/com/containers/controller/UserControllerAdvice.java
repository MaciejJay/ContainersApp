package com.containers.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    public ModelAndView handleException(RuntimeException exception) {
        ModelAndView exceptionModelAndView = new ModelAndView("userException");
        exceptionModelAndView.addObject("message", exception.getMessage());
        return exceptionModelAndView;
    }
}