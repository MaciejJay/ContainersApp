package com.containers.repository;

import com.containers.model.Container;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContainerRepository extends JpaRepository<Container, String> {

    Optional<Container> findById(String noContainer);

}
