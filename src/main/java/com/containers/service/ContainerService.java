package com.containers.service;

import com.containers.repository.ContainerDamageRepository;
import org.springframework.stereotype.Service;

@Service
public class ContainerService {

    private final ContainerDamageRepository containerDamageRepository;

    public ContainerService(ContainerDamageRepository containerDamageRepository) {
        this.containerDamageRepository = containerDamageRepository;
        System.out.println("test");
    }
}
