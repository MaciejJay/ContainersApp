package com.containers.model.formHelpers;

import com.containers.model.Container;
import com.containers.model.DamageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportFormDTO {
    private String inOut;
    private String inOutDate;
    private String containerPrefixAndNo;
    private String containerType;
    private String orderNo;
    private String lastName;
    private String truckNo;
    private String chassisNo;
    private String wagonNo;
    private DamageType damageType;
    private String description;
    private String estimatedCostOfRepair;
    private ContainerState containerState;
    private ContainerNeeds containerNeeds;

    public ReportFormDTO(Container container) {
        this.containerPrefixAndNo = container.getContainerIdNumber();
        this.containerType = container.getContainerType();
    }

    public String getRandomPin() {
        SecureRandom secureRandom = new SecureRandom();
        return Integer.toString(secureRandom.nextInt(9999));
    }

}
