package com.containers.service;

import com.containers.exceptions.ContainerNotFoundException;
import com.containers.exceptions.ShipownerHasNotAnyContainerException;
import com.containers.model.Container;
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
        return containerRepository.save(container);
    }

    public Container updateContainer(Container container) {
        containerRepository.deleteById(container.getNoContainer());
        return containerRepository.save(container);
    }

    public void deleteContainer(String noContainer) {
        containerRepository.deleteById(noContainer);
    }

    public Container findContainerById(String noContainer) {
        Optional<Container> containerById = containerRepository.findByNoContainer(noContainer);
        if (containerById.isPresent()) {
            return containerById.get();
        } else throw new ContainerNotFoundException("Container not found");
    }

    //TODO:
//    public Set<Container> findContainersByShipownerId(Long id) {
//        Optional<Container> shipownerContainers = containerRepository.findContainersByContainerShipowner_Id(id);
//        if (shipownerContainers.isPresent()) {
//            return shipownerContainers; //TODO: Jak to zrobić?
//        } else throw new ShipownerHasNotAnyContainerException("Containers not found for" + id);
//    }

    public Set<Container> findContainersByShipownerId(Long id) {
        Set<Container> shipownerContainers = containerRepository.findByContainerShipowner_Id(id);
        if (!shipownerContainers.isEmpty()) {
            return shipownerContainers;
        } else throw new ShipownerHasNotAnyContainerException("Containers not found for: " + id);
    }
}
