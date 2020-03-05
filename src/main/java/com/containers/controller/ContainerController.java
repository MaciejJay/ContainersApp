package com.containers.controller;

import com.containers.model.Container;
import com.containers.service.ContainerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/containers")
public class ContainerController {

    private ContainerService containerService;

    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @GetMapping("")
    public ModelAndView containersPage(@RequestParam(required = false) String containerNo) {
        ModelAndView modelAndView = new ModelAndView("containersPage");
        if (containerNo == null) {
            return modelAndView.addObject("containerSet", containerService.findAllContainers());
        } else
            return modelAndView.addObject("containerSet", containerService.findContainerByIdSet(containerNo.trim()));
    }

    @GetMapping("/add")
    public ModelAndView createContainerView() {
        ModelAndView modelAndView = new ModelAndView("addContainer");
        modelAndView.addObject("container", new Container());
        modelAndView.addObject("update", false);
        return modelAndView;
    }

    @GetMapping("/update/{noContainer}")
    public ModelAndView updateContainerView(@PathVariable String noContainer) {
        ModelAndView modelAndView = new ModelAndView("addContainer");
        modelAndView.addObject(containerService.findContainerById(noContainer));
        modelAndView.addObject("update", true);
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateContainer(@ModelAttribute Container container) {
        containerService.updateContainer(container);
        return "redirect:/containers/";
    }

    @PostMapping("/add")
    public String addContainer(@ModelAttribute Container container) {
        containerService.saveContainer(container);
        return "redirect:/containers/";
    }


    @GetMapping("/delete/{containerNo}")
    public String deleteContainer(@PathVariable String containerNo) {
        containerService.deleteContainer(containerNo);
        return "redirect:/containers/";
    }
//
//    @GetMapping("/containers/add/model")
//    public ModelAndView containersAddModel() {
//        ModelAndView modelAndView = new ModelAndView("containerModel");
//        return new ModelAndView("containerModel");
//    }
}
