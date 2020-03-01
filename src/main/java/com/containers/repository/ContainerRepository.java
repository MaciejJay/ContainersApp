package com.containers.repository;

import com.containers.model.Container;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface ContainerRepository extends JpaRepository<Container, String> {

    Optional<Container> findByNoContainer(String noContainer);

}
