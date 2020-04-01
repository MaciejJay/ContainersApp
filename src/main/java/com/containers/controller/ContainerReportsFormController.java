package com.containers.controller;

import com.containers.model.Damage;
import com.containers.model.DamageType;
import com.containers.model.Report;
import com.containers.model.Side;
import com.containers.model.formHelpers.ContainerNeeds;
import com.containers.model.formHelpers.ContainerState;
import com.containers.model.formHelpers.ReportFormDTO;
import com.containers.service.ContainerReportService;
import com.containers.service.ContainerService;
import com.containers.service.DamageService;
import com.containers.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EnumSet;

@Controller
@RequestMapping("/reports")
public class ContainerReportsFormController {

    private final ContainerService containerService;
    private final ContainerReportService reportService;
    private final UserService userService;
    private final DamageService damageService;

    public ContainerReportsFormController(ContainerReportService reportService, ContainerService containerService, UserService userService, DamageService damageService) {
        this.reportService = reportService;
        this.containerService = containerService;
        this.userService = userService;
        this.damageService = damageService;
    }

    @GetMapping("{containerSerialNo}")
    public ModelAndView containerReports(@PathVariable String containerSerialNo) {
        return new ModelAndView("report/ContainerReportsPage")
                .addObject("reports", reportService.findAllContainerReports(containerSerialNo));
    }

    @GetMapping("/form/{containerSerialNo}")
    public ModelAndView reportsFormPage(@PathVariable String containerSerialNo) {

        ReportFormDTO reportFormDTO = new ReportFormDTO(containerService.findContainerById(containerSerialNo));

        EnumSet<DamageType> types = EnumSet.allOf(DamageType.class);
        EnumSet<ContainerNeeds> needs = EnumSet.allOf(ContainerNeeds.class);
        EnumSet<ContainerState> states = EnumSet.allOf(ContainerState.class);

        return new ModelAndView("report/reportFormPage")
                .addObject("types", types)
                .addObject("needs", needs)
                .addObject("states", states)
                .addObject("reportFormDTO", reportFormDTO);
    }

    @PostMapping("/add")
    public String addRaport(@ModelAttribute ReportFormDTO reportFormDTO) {
        Report report = reportService.saveContainerReport(
                new Report(
                        containerService.findContainerById(reportFormDTO.getContainerPrefixAndNo()),
                        userService.findUserById("przydan"),
                        LocalDateTime.now(),
                        reportFormDTO.getRandomPin(),
                        reportFormDTO.getInOut(),
                        LocalDate.parse(reportFormDTO.getInOutDate(), DateTimeFormatter.BASIC_ISO_DATE),
                        reportFormDTO.getOrderNo(),
                        reportFormDTO.getLastName(),
                        reportFormDTO.getTruckNo(),
                        reportFormDTO.getChassisNo(),
                        reportFormDTO.getWagonNo(),
                        reportFormDTO.getEstimatedCostOfRepair(),
                        reportFormDTO.getContainerState(),
                        reportFormDTO.getContainerNeeds()
                ));
        damageService.saveContainerDamage(
                new Damage(
                        reportFormDTO.getDescription(),
                        "testPathToImage",
                        reportFormDTO.getDamageType(),
                        Side.DOOR
                ));

        containerService.addReport(report, reportFormDTO.getContainerPrefixAndNo());

        return "redirect:/reports/" + reportFormDTO.getContainerPrefixAndNo();
    }
}

