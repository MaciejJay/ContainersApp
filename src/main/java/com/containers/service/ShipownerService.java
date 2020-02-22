package com.containers.service;

import com.containers.exceptions.ShipownerNotFoundByIdException;
import com.containers.model.Shipowner;
import com.containers.repository.ShipownerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipownerService {
    private ShipownerRepository repository;

    public ShipownerService(ShipownerRepository repository) {
        this.repository = repository;
    }

    public Shipowner getShipownerById(Long id) {
        Optional<Shipowner> byId = repository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }else {
            throw new ShipownerNotFoundByIdException("Shipowner not found by ID" + id);
        }
    }

}
