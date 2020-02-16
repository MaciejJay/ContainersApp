package com.containers.repository;

import com.containers.model.Container;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface ContainerRepository extends JpaRepository<Container, String> {

    Optional<Container> findByNoContainer(String noContainer);

    @Query("SELECT c FROM Container c WHERE c.containerShipowner.id = :shipowner_id")
    Set<Container> findByContainerShipowner_Id(@Param("shipowner_id") Long id);

    //TODO: Jak ogarnąć to z Optional<Container> ??
//    Optional<Container> findContainersByContainerShipowner_Id(Long id);
//    Set<Container> findByContainerShipowner_Id(Long id);
}
