package com.containers.service;

import com.containers.model.Report;
import com.containers.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ContainerReportService {

    private final ReportRepository reportRepository;

    public ContainerReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Set<Report> findAllContainerReports(String containerIdNumber) {
        return reportRepository.findByContainer_ContainerIdNumber(containerIdNumber);
    }

    public Report saveContainerReport(Report report) {
        return reportRepository.save(report);
    }

    public void deleteContainerReport(Long id) {
        reportRepository.deleteById(id);
    }
}
