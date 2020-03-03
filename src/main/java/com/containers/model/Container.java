package com.containers.model;

import org.springframework.data.util.Lazy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;

@Entity
public class Container {

    @Id
    private String containerIdNumber;
    private String containerType;
    private String containerShipOwner;
    @Column(unique = true)
    private String containerNoPin;

    @OneToMany(targetEntity = Damage.class,
            fetch = LAZY,
            cascade = ALL)

    private Set<Damage> containerDamage;


    public Container() {
    }

    public Container(String containerIdNumber, String containerType, String containerShipOwner, String containerNoPin, Set<Damage> containerDamage) {
        this.containerIdNumber = containerIdNumber;
        this.containerType = containerType;
        this.containerShipOwner = containerShipOwner;
        this.containerNoPin = containerNoPin;
        this.containerDamage = containerDamage;
    }

    public String getContainerIdNumber() {
        return containerIdNumber;
    }

    public void setContainerIdNumber(String containerIdNumber) {
        this.containerIdNumber = containerIdNumber;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public String getContainerShipOwner() {
        return containerShipOwner;
    }

    public void setContainerShipOwner(String containerShipOwner) {
        this.containerShipOwner = containerShipOwner;
    }

    public String getContainerNoPin() {
        return containerNoPin;
    }

    public void setContainerNoPin(String containerNoPin) {
        this.containerNoPin = containerNoPin;
    }

    public Set<Damage> getContainerDamage() {
        return containerDamage;
    }

    public void setContainerDamage(Set<Damage> containerDamage) {
        this.containerDamage = containerDamage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return Objects.equals(containerIdNumber, container.containerIdNumber) &&
                Objects.equals(containerType, container.containerType) &&
                Objects.equals(containerShipOwner, container.containerShipOwner) &&
                Objects.equals(containerNoPin, container.containerNoPin) &&
                Objects.equals(containerDamage, container.containerDamage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(containerIdNumber, containerType, containerShipOwner, containerNoPin, containerDamage);
    }

    @Override
    public String toString() {
        return "Container{" +
                "containerIdNumber='" + containerIdNumber + '\'' +
                ", containerType='" + containerType + '\'' +
                ", containerShipOwner='" + containerShipOwner + '\'' +
                ", containerNoPin='" + containerNoPin + '\'' +
                ", containerDamage=" + containerDamage +
                '}';
    }
}
