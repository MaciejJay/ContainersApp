package com.containers.repository;

import com.containers.model.ContainerRaport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ContainerRaportRepository extends JpaRepository<ContainerRaport, Long> {

    Set<ContainerRaport> findByContainer_ContainerIdNumber(String container_containerIdNumber);

    @Query("SELECT cr FROM ContainerRaport cr WHERE cr.container.containerIdNumber = :containerIdNumber")
    Set<ContainerRaport> fetchContainerRapportsByContainerId(@Param("containerIdNumber") String containerIdNumber);

}
