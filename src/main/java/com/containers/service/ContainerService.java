package com.containers.service;

import com.containers.exceptions.ContainerNotFoundException;
import com.containers.exceptions.UserNotFoundException;
import com.containers.model.Container;
import com.containers.repository.ContainerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContainerService {

    private final ContainerRepository containerRepository;

    public ContainerService(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    public Container findContainerById(String noContainer) {
        Optional<Container> containerById = containerRepository.findById(noContainer);
        if (containerById.isPresent()) {
            return containerById.get();
        } else throw new ContainerNotFoundException("Container not found");
    }


}
