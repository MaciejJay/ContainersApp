package com.containers.repository;

import com.containers.model.ContainerDamage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContainerDamageRepository extends JpaRepository<ContainerDamage, Long> {
    
}
