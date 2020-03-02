package com.containers.controller;

import com.containers.model.Container;
import com.containers.service.ContainerService;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContainerController {

    private ContainerService containerService;

    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @GetMapping("/containers/add")
    public ModelAndView containerAdd() {
        return new ModelAndView("addNewContainer");
    }

    @GetMapping("/containers/add/model")
    public ModelAndView containersAddModel() {
        return new ModelAndView("containerModel");
    }

    @GetMapping("/containers/find")
    public ModelAndView findContainer(@RequestParam String containerNo) {
        ModelAndView modelAndView = new ModelAndView("findContainer");
        modelAndView.addObject("findContainer", containerService.findContainerById(containerNo));
        return modelAndView;
    }

    @PostMapping("/containers/update")
    public ModelAndView updateContainer(@ModelAttribute Container container) {
        ModelAndView modelAndView = new ModelAndView("updateContainer");
        modelAndView.addObject("updateContainer", containerService.updateContainer(container));
        return modelAndView;
    }

    @GetMapping("/containers/delete")
    public String deleteContainer(@RequestParam String containerNo) {
        containerService.deleteContainer(containerNo);
        return "redirect:/containers";
    }

    @GetMapping("/container/status")
    public ModelAndView getDamageStatus() {
        return new ModelAndView("containerStatus");
    }
}
