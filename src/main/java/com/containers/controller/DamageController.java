package com.containers.controller;

import com.containers.model.Container;
import com.containers.model.Damage;
import com.containers.model.DamageType;
import com.containers.model.Side;
import com.containers.service.ContainerService;
import com.containers.service.DamageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.EnumSet;
import java.util.Set;

@Controller
@RequestMapping("/damage")
public class DamageController {

    private final DamageService damageService;
    private final ContainerService containerService;

    public DamageController(DamageService damageService, ContainerService containerService) {
        this.damageService = damageService;
        this.containerService = containerService;
    }

//    @GetMapping("/{containerSerialNo}")
//    public ModelAndView showDamagePage(@PathVariable String containerSerialNo) {
//        Container containerById = containerService.findContainerById(containerSerialNo);
//        ModelAndView modelAndView = new ModelAndView("rapportsPage", "container", containerById);
//        EnumSet<Side> sideEnumSet = EnumSet.allOf(Side.class);
//        EnumSet<DamageType> damageTypeEnumSet = EnumSet.allOf(DamageType.class);
//        modelAndView.addObject("side", sideEnumSet);
//        modelAndView.addObject("damageType", damageTypeEnumSet);
//        modelAndView.addObject("damage", new Damage());
//        return modelAndView;
//    }

    @GetMapping("/add/model")
    public ModelAndView containersAddModel() {
        ModelAndView modelAndView = new ModelAndView("containerModel");
        return new ModelAndView("containerModel");
    }

//    #################################################################
//
//    @PostMapping("/damages/add")
//    public String addNewDamageToContainer(@ModelAttribute Damage damage) {
//        damageService.saveContainerDamage(damage);
//        return "redirect:/damages";
//    }
//
//    @GetMapping("/damages")
//    public Set<Damage> findAllDamage() {
//        return damageService.findAllDamage();
//    }
//
//    @PostMapping("/damages/update")
//    public String updateContainerDamage(@ModelAttribute Damage damage) {
//        damageService.saveContainerDamage(damage);
//        return "redirect:/damages";
//    }
//
//    @GetMapping("/damages/delete/{id}")
//    public String deleteContainerDamage(@PathVariable Long id) {
//        damageService.deleteContainerDamage(id);
//        return "redirect:/damages";
//    }
//
//    @GetMapping("/damages/history")
//    public ModelAndView getDamagesHistory() {
//        return new ModelAndView("damagesHistory");
//    }
}
