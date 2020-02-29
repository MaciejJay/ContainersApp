package com.containers.service;

import com.containers.model.Damage;
import com.containers.repository.ContainerDamageRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ContainerDamageService {

    private final ContainerDamageRepository containerDamageRepository;

    public ContainerDamageService(ContainerDamageRepository containerDamageRepository) {
        this.containerDamageRepository = containerDamageRepository;
    }

    public Set<Damage> findAllDamage() {
        return new HashSet<>(containerDamageRepository.findAll());
    }

    public Damage addNewContainerDamage(Damage damage) {
        return containerDamageRepository.save(damage);
    }

    public Damage updateContainerDamage(Damage damage) {
        containerDamageRepository.delete(damage);
       return containerDamageRepository.save(damage);
    }
}