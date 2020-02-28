package com.containers.controller;

import com.containers.model.DTO.WorkEstimateExcelDTO;
import com.containers.service.ContainerDamageService;
import com.containers.service.ContainerService;
import com.containers.utilities.xssf.XlsxService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class ContainerController {

    private ContainerService containerService;
    private ContainerDamageService damageService;
    private XlsxService xlsxService;

    public ContainerController(ContainerService containerService, ContainerDamageService damageService, XlsxService xlsxService) {
        this.containerService = containerService;
        this.damageService = damageService;
        this.xlsxService = xlsxService;
    }

    @GetMapping("/")
    public ModelAndView getHomePage(){
        return new ModelAndView("index");
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }

    @GetMapping("/menu")
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

    @GetMapping("/user/edit")
    public ModelAndView editUser(){
        return new ModelAndView("editUser");
    }

    // TODO: zostawiamy tutaj czy przenosimy do RaportController ??
    //##||##
    //##||##
    //##\/##
    @GetMapping("/raport/create")
    public ModelAndView createRaportView() {
        ModelAndView modelAndView = new ModelAndView("containerRaportPage");
        modelAndView.addObject("workEstimateExcelDTO", new WorkEstimateExcelDTO());
        return modelAndView;
    }

    @PostMapping(value = "/raport") //TODO: XLSX i PDF czy osobno ??
    public String gatherDataToRaport(@ModelAttribute WorkEstimateExcelDTO excelDTO) {
        try {
            xlsxService.runWriter(excelDTO);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return "redirect:/damages/history";
    }
    //##/\##
    //##||##
    //##||##

}
