package com.containers.model.DTO;


import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

public class WorkEstimateExcelDTO {
    private String customer;
    private String terminal;
    private LocalDate dateOfEstimate;
    private Set<String> locations;
    private Set<String> components;
    private Set<String> damageCodes;
    private Set<String> repairCodes;
    private String name;
    private LocalDate dateOfCreateDocument;
    private String Prefix;
    private String ContainerSerialNo;
    private String CD; // co to ??
    private LocalDate inOutDate;
    private String containerType;
    private Map<String, String> damageDescriptionAndHours;
    private Map<String, String> repairDescriptionAndHours;
    private String repairHandling;
    private Double labourRate;

}
