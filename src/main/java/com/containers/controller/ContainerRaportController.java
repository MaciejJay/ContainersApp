package com.containers.controller;

import com.containers.model.ContainerRaport;
import com.containers.service.ContainerRaportService;
import com.containers.service.ContainerService;
import com.containers.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("/rapports")
public class ContainerRaportController {

    private final ContainerRaportService raportService;
    private final ContainerService containerService;
    private final UserService userService;

    public ContainerRaportController(ContainerRaportService raportService, ContainerService containerService, UserService userService) {
        this.raportService = raportService;
        this.containerService = containerService;
        this.userService = userService;
    }

    @GetMapping("/{containerSerialNo}")
    public ModelAndView rapportsPage(@PathVariable String containerSerialNo) {
        ModelAndView modelAndView = new ModelAndView("rapportsPage");
        modelAndView.addObject("container", containerService.findContainerById(containerSerialNo));
        modelAndView.addObject("rapports", raportService.findAllContainerRapports(containerSerialNo));
        return modelAndView;
    }

    @GetMapping("/add/{containerSerialNo}")
    public String createContainerRaportFormPage(@PathVariable String containerSerialNo) {
//        ContainerRaport containerRaport =
//                new ContainerRaport(
//                        containerService.findContainerById(containerSerialNo),
//                        userService.
//                        LocalDate.now());
//        raportService.saveContainerRaport(containerRaport);
        return "redirect:/rapports/" + containerSerialNo; /* TODO redirect to Damage controller ?? */
    }

//    @PostMapping("/forms/add")
//    public String addNewContainerForm(@ModelAttribute ContainerRaport containerRaport) {
//        raportService.saveContainerRaport(containerRaport);
//        return "redirect:/forms";
//    }
//
//    @GetMapping("/forms")
//    public Set<ContainerRaport> findAllContainerForm() {
//        return raportService.findAllContainerRapports();
//    }
//
//    @PostMapping("/forms/update")
//    public String updateContainerForm(@ModelAttribute ContainerRaport containerRaport) {
//        raportService.saveContainerRaport(containerRaport);
//        return "redirect:/forms";
//    }
//
//    @GetMapping("/forms/delete/{id}")
//    public String deleteContainerForm(@PathVariable Long id) {
//        raportService.deleteContainerRaport(id);
//        return "redirect:/forms";
//    }
}

