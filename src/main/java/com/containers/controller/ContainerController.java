package com.containers.controller;

import com.containers.service.ContainerService;
import org.springframework.stereotype.Controller;

@Controller
public class ContainerController {

    private ContainerService containerService;

    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }



}
