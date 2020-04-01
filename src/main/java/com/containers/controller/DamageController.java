package com.containers.controller;

import com.containers.model.Damage;
import com.containers.service.DamageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/damage")
public class DamageController {

    private final DamageService damageService;

    public DamageController(DamageService damageService) {
        this.damageService = damageService;
    }

    @PostMapping("/damages/add")
    public String addNewDamageToContainer(@ModelAttribute Damage damage) {
        damageService.saveContainerDamage(damage);
        return "redirect:/damages";
    }

    @GetMapping("/damages")
    public Set<Damage> findAllDamage() {
        return damageService.findAllDamage();
    }

    @PostMapping("/damages/update")
    public String updateContainerDamage(@ModelAttribute Damage damage) {
        damageService.saveContainerDamage(damage);
        return "redirect:/damages";
    }

    @GetMapping("/damages/delete/{id}")
    public String deleteContainerDamage(@PathVariable Long id) {
        damageService.deleteContainerDamage(id);
        return "redirect:/damages";
    }
}
