package com.containers.service;

import com.containers.model.ContainerRaport;
import com.containers.repository.ContainerRaportRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ContainerRaportService {

    private final ContainerRaportRepository containerRaportRepository;

    public ContainerRaportService(ContainerRaportRepository containerRaportRepository) {
        this.containerRaportRepository = containerRaportRepository;
    }

    public Set<ContainerRaport> findAllContainerRapports(String containerIdNumber) {
        return containerRaportRepository.fetchContainerRapportsByContainerId(containerIdNumber);
    }

    public ContainerRaport saveContainerRaport(ContainerRaport containerRaport) {
        return containerRaportRepository.save(containerRaport);
    }

    public void deleteContainerRaport(Long id) {
        containerRaportRepository.deleteById(id);
    }
}
