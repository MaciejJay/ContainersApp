package com.containers.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;

@Entity
public class Container {

    @Id
    private String noContainer;
    private String containerNoPin;
    private String containerType;

    @OneToMany(targetEntity = ContainerDamage.class,
            fetch = EAGER,
            cascade = ALL)

    private Set<ContainerDamage> containerDamage;

    @ManyToOne(targetEntity = Shipowner.class
            , fetch = EAGER,
            cascade = {DETACH, MERGE, PERSIST, REFRESH})
    private Shipowner shipowner;

    public Container() {
    }

    public Container(String noContainer, String containerNoPin, String containerType, Set<ContainerDamage> containerDamage) {
        this.noContainer = noContainer;
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

    public Shipowner getShipowner() {
        return shipowner;
    }

    public void setShipowner(Shipowner shipowner) {
        this.shipowner = shipowner;
    }
}
