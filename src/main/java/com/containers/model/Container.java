package com.containers.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Container {

    @Id
    @GeneratedValue(generator = "ContainerSeq")
    @SequenceGenerator(name = "ContainerSeq", sequenceName = "container_seq", allocationSize = 1)
    private Long id;

    private String noContainer;
    private String containerNoPin;
    private String containerType;

    @OneToMany(targetEntity = ContainerDamage.class, fetch = FetchType.EAGER)
    private Set<ContainerDamage> containerDamage;


    @ManyToOne(targetEntity = ContainerShipowner.class)
    private ContainerShipowner containerShipowner;

    public Container() {
    }

    public Container(String noContainer, String containerNoPin, String containerType, Set<ContainerDamage> containerDamage) {
        this.noContainer = noContainer;
        this.containerNoPin = containerNoPin;
        this.containerType = containerType;
        this.containerDamage = containerDamage;
    }

    public Long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return Objects.equals(id, container.id) &&
                Objects.equals(noContainer, container.noContainer) &&
                Objects.equals(containerNoPin, container.containerNoPin) &&
                Objects.equals(containerType, container.containerType) &&
                Objects.equals(containerDamage, container.containerDamage) &&
                Objects.equals(containerShipowner, container.containerShipowner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, noContainer, containerNoPin, containerType, containerDamage, containerShipowner);
    }
}
