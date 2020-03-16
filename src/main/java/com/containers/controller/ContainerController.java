package com.containers.controller;

import com.containers.model.Container;
import com.containers.service.ContainerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContainerController {

    private ContainerService containerService;

    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @GetMapping(value = "/containers/add")
    public ModelAndView containerAdd() {
        ModelAndView modelAndView = new ModelAndView("addNewContainer");
        modelAndView.addObject("newContainer", new Container());
        modelAndView.addObject("updateContainer", false);
        return modelAndView;
    }

    @PostMapping("/containers")
    public String createContainer(@ModelAttribute Container container) {
        containerService.saveContainer(container);
        return "redirect:/containers";
    }

    @PostMapping(value = "/containers/newCon")
    public String saveContainer(@ModelAttribute Container container) {
        Container savedContainer = containerService.saveContainer(container);
        return "redirect:/containers/find" + savedContainer.getContainerIdNumber();
    }

    @GetMapping("/containers/add/model")
    public ModelAndView containersAddModel() {
        ModelAndView modelAndView = new ModelAndView("containerModel");
        return new ModelAndView("containerModel");
    }

    @GetMapping(value = "/containers/find")
    public ModelAndView findContainer(@RequestParam String containerNo) {
        ModelAndView modelAndView = new ModelAndView("findContainer");
        if (containerNo == null) {
            return modelAndView.addObject("findContainer", containerService.findAllContainers());
        } else
            return modelAndView.addObject("findContainer", containerService.findContainerById(containerNo));
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
