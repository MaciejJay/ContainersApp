package com.containers.service;

import com.containers.exceptions.ContainerAlreadyExistException;
import com.containers.exceptions.ContainerNotFoundException;
import com.containers.model.Container;
import com.containers.model.Report;
import com.containers.repository.ContainerRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ContainerService {

    private final ContainerRepository containerRepository;

    public ContainerService(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    public Set<Container> findAllContainers() {
        return new HashSet<>(containerRepository.findAll());
    }

    public Container saveContainer(Container container) {
        if (!containerRepository.existsById(container.getContainerIdNumber())) {
            return containerRepository.save(container);
        } else {
            throw new ContainerAlreadyExistException("Container already exist");
        }
    }

    public Container updateContainer(Container container) {
        containerRepository.deleteById(container.getContainerIdNumber());
        return containerRepository.save(container);
    }

    public void deleteContainer(String noContainer) {
        containerRepository.deleteById(noContainer);
    }

    public Container findContainerById(String noContainer) {
        Optional<Container> containerById = containerRepository.findById(noContainer);
        if (containerById.isPresent()) {
            return containerById.get();
        } else throw new ContainerNotFoundException("Container not found");
    }

    // TODO: stream.findfirst.orElse lub iterator
    public Set<Container> findContainerByIdSet(String noContainer) {
        Optional<Container> containerById = containerRepository.findById(noContainer);
        if (containerById.isPresent()) {
            Set<Container> containers = new HashSet<>();
            containers.add(containerById.get());
            return containers;
        } else throw new ContainerNotFoundException("Container not found");
    }

    public void addReport(Report report, String noContainer) {
        Container containerById = findContainerById(noContainer);
        containerById.addReport(report);
        updateContainer(containerById);
    }
}
