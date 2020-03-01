package com.containers.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;

@Entity
public class Container {

    @Id
    private String noContainer;
    private String containerNoPin;
    private String containerType;

    @OneToMany(targetEntity = Damage.class,
            fetch = EAGER,
            cascade = ALL)

    private Set<Damage> containerDamage;


    public Container() {
    }

    public Container(String noContainer, String containerNoPin, String containerType, Set<Damage> containerDamage) {
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

    public Set<Damage> getDamage() {
        return containerDamage;
    }

    public void setDamage(Set<Damage> containerDamage) {
        this.containerDamage = containerDamage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return Objects.equals(noContainer, container.noContainer) &&
                Objects.equals(containerNoPin, container.containerNoPin) &&
                Objects.equals(containerType, container.containerType) &&
                Objects.equals(containerDamage, container.containerDamage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noContainer, containerNoPin, containerType, containerDamage);
    }

    @Override
    public String toString() {
        return "Container{" +
                "noContainer='" + noContainer + '\'' +
                ", containerNoPin='" + containerNoPin + '\'' +
                ", containerType='" + containerType + '\'' +
                ", containerDamage=" + containerDamage +
                '}';
    }
}
