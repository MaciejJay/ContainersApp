package com.containers.repository;

import com.containers.model.Shipowner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipownerRepository extends JpaRepository<Shipowner, Long> {
}
