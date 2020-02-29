package com.containers.repository;

import com.containers.model.Damage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContainerDamageRepository extends JpaRepository<Damage, Long> {
}
