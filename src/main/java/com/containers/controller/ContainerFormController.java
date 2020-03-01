package com.containers.controller;

import com.containers.model.ContainerForm;
import com.containers.service.ContainerFormService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class ContainerFormController {

    private final ContainerFormService containerFormService;

    public ContainerFormController(ContainerFormService containerFormService) {
        this.containerFormService = containerFormService;
    }

    @PostMapping("/forms/add")
    public String addNewContainerForm(@ModelAttribute ContainerForm containerForm) {
        containerFormService.saveContainerForm(containerForm);
        return "redirect:/forms";
    }

    @GetMapping("/forms")
    public Set<ContainerForm> findAllContainerForm() {
        return containerFormService.findAllContainerForm();
    }

    @PostMapping("/forms/update")
    public String updateContainerForm(@ModelAttribute ContainerForm containerForm) {
        containerFormService.saveContainerForm(containerForm);
        return "redirect:/forms";
    }

    @GetMapping("/forms/delete/{id}")
    public String deleteContainerForm(@PathVariable Long id) {
        containerFormService.deleteContainerForm(id);
        return "redirect:/forms";
    }
}

