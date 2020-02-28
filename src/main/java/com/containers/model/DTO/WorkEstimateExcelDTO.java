package com.containers.model.DTO;


import com.containers.model.Container;
import com.containers.model.ContainerDamage;
import com.containers.model.DamageTypeEnum;
import com.containers.model.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.persistence.Embeddable;
import javax.persistence.EntityResult;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;


@Data
public class WorkEstimateExcelDTO {
    private String customer;
    private String terminal;
    private LocalDate dateOfEstimate;
    private Set<String> locations;
    private Set<String> components;
    private Set<DamageTypeEnum> damageCodes;
    private Set<String> repairCodes;
    private String name;
    private LocalDate dateOfCreateDocument;
    private String prefix;
    private String containerSerialNo;
    private String CD; // co to ??
    private LocalDate inOutDate;
    private String containerType;
    private Map<String, String> damageDescriptionAndHours;
    private Map<String, String> repairDescriptionAndHours;
    private String repairHandling;
    private Double labourRate;


    public WorkEstimateExcelDTO() {
    }

    public WorkEstimateExcelDTO(Container container, ContainerDamage damage, User u, String customer) {
        this.customer = customer;
        // TODO: ...
//        this.terminal = terminal;
//        this.dateOfEstimate = dateOfEstimate;
//        this.locations = locations;
//        this.components = components;
//        this.repairCodes = repairCodes;
//        this.dateOfCreateDocument = dateOfCreateDocument;
//        this.CD = CD;
//        this.inOutDate = inOutDate;
//        this.damageDescriptionAndHours = damageDescriptionAndHours;
//        this.repairDescriptionAndHours = repairDescriptionAndHours;
//        this.repairHandling = repairHandling;
//        this.labourRate = labourRate;
//        damageCodes = damage.getTypeEnums();
        name = u.getFirstName() + " " + u.getLastName();
        prefix = container.getShipowner().getPrefix();
        containerSerialNo = container.getNoContainer();
        containerType = container.getContainerType();
    }


}
