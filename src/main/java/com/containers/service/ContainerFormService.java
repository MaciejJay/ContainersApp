package com.containers.service;

import com.containers.model.ContainerForm;
import com.containers.repository.ContainerFormRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ContainerFormService {

    private final ContainerFormRepository containerFormRepository;

    public ContainerFormService(ContainerFormRepository containerFormRepository) {
        this.containerFormRepository = containerFormRepository;
    }

    public Set<ContainerForm> findAllContainerForm() {
        return new HashSet<>(containerFormRepository.findAll());
    }

    public ContainerForm saveContainerForm(ContainerForm containerForm) {
        return containerFormRepository.save(containerForm);
    }

    public void deleteContainerForm(Long id) {
        containerFormRepository.deleteById(id);
    }
}
