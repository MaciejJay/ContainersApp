package com.containers.service;

import com.containers.model.Damage;
import com.containers.repository.DamageRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DamageService {

    private final DamageRepository damageRepository;

    public DamageService(DamageRepository damageRepository) {
        this.damageRepository = damageRepository;
    }

    public Set<Damage> findAllDamage() {
        return new HashSet<>(damageRepository.findAll());
    }

    public Damage addNewContainerDamage(Damage damage) {
        return damageRepository.save(damage);
    }

    public Damage updateContainerDamage(Damage damage) {
        damageRepository.delete(damage);
        return damageRepository.save(damage);
    }

    public void deleteContainerDamage(Long id) {
        damageRepository.deleteById(id);
    }
}