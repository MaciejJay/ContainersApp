package com.containers.controller;

import com.containers.model.Damage;
import com.containers.service.DamageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class DamageController {

    private DamageService damageService;

    public DamageController(DamageService damageService) {
        this.damageService = damageService;
    }

    @PostMapping("/damage/add")
    public String addNewDamageToContainer(@ModelAttribute Damage damage) {
        damageService.addNewContainerDamage(damage);
        return "redirect:/damage";
    }

    @GetMapping("/damage")
    public Set<Damage> findAllDamage() {
        return damageService.findAllDamage();
    }

    @PostMapping("/damage/update")
    public String updateContainerDamage(@ModelAttribute Damage damage) {
        damageService.updateContainerDamage(damage);
        return "redirect:/damage";
    }

    @GetMapping("/damage/delete/{id}")
    public String deleteContainerDamage(@PathVariable Long id) {
        damageService.deleteContainerDamage(id);
        return "redirect:/damage";
    }
}
