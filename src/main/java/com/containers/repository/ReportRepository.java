package com.containers.repository;

import com.containers.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ReportRepository extends JpaRepository<Report, Long> {

//    @Query("SELECT cr FROM Report cr WHERE cr.container.containerIdNumber = :containerIdNumber")
//    Set<Report> fetchContainerReportsByContainerId(@Param("containerIdNumber") String containerIdNumber);

    Set<Report> findByContainer_ContainerIdNumber(String containerIdNumber);


}
