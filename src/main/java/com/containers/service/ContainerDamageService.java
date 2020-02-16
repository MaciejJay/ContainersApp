package com.containers.service;

import com.containers.model.ContainerDamage;
import com.containers.repository.ContainerDamageRepository;

import java.util.HashSet;
import java.util.Set;

public class ContainerDamageService {

    private final ContainerDamageRepository containerDamageRepository;

    public ContainerDamageService(ContainerDamageRepository containerDamageRepository) {
        this.containerDamageRepository = containerDamageRepository;
    }

    public Set<ContainerDamage> findAllDamage() {
        return new HashSet<>(containerDamageRepository.findAll());
    }

    public ContainerDamage addNewContainerDamage(ContainerDamage damage) {
        return containerDamageRepository.save(damage);
    }

    public ContainerDamage updateContainerDamage(ContainerDamage damage) {
        containerDamageRepository.delete(damage);
       return containerDamageRepository.save(damage);
    }
}