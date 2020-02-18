package com.containers.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;

@Entity
@EqualsAndHashCode
@ToString
public class Container {

    @Id
    private String noContainer;
    private String prefix;
    private String containerNoPin;
    private String containerType;

    @OneToMany(targetEntity = ContainerDamage.class,
            fetch = EAGER,
            cascade = ALL)
    private Set<ContainerDamage> containerDamage;


    @ManyToOne(targetEntity = ContainerShipowner.class
            , fetch = EAGER,
            cascade = {DETACH, MERGE, PERSIST, REFRESH})
    private ContainerShipowner containerShipowner;

    public Container() {
    }

    public Container(String noContainer, String prefix, String containerNoPin, String containerType, Set<ContainerDamage> containerDamage) {
        this.noContainer = noContainer;
        this.prefix = prefix;
        this.containerNoPin = containerNoPin;
        this.containerType = containerType;
        this.containerDamage = containerDamage;
    }

    public String getNoContainer() {
        return noContainer;
    }

    public void setNoContainer(String noContainer) {
        this.noContainer = noContainer;
    }

    public String getContainerNoPin() {
        return containerNoPin;
    }

    public void setContainerNoPin(String containerNoPin) {
        this.containerNoPin = containerNoPin;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public Set<ContainerDamage> getContainerDamage() {
        return containerDamage;
    }

    public void setContainerDamage(Set<ContainerDamage> containerDamage) {
        this.containerDamage = containerDamage;
    }

    public ContainerShipowner getContainerShipowner() {
        return containerShipowner;
    }

    public void setContainerShipowner(ContainerShipowner containerShipowner) {
        this.containerShipowner = containerShipowner;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
