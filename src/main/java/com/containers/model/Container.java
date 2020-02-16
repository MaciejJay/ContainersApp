package com.containers.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Container {

    @Id
    @GeneratedValue(generator = "ContainerSeq")
    @SequenceGenerator(name = "ContainerSeq", sequenceName = "container_seq", allocationSize = 1)
    private Long id;

    private String noContainer;
    private String containerNoPin;
    private String containerType;

    @ManyToOne(targetEntity = ContainerDamage.class)
    private ContainerDamage containerDamage;

//    @OneToOne
    private ContainerShipowners containerShipowners;

    @ManyToOne(targetEntity = User.class)
    private User user;

    public Container() {
    }

    public Container(String noContainer, String containerNoPin, String containerType, ContainerDamage containerDamage, ContainerShipowners containerShipowners, User user) {
        this.noContainer = noContainer;
        this.containerNoPin = containerNoPin;
        this.containerType = containerType;
        this.containerDamage = containerDamage;
        this.containerShipowners = containerShipowners;
        this.user = user;
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

    public ContainerDamage getContainerDamage() {
        return containerDamage;
    }

    public void setContainerDamage(ContainerDamage containerDamage) {
        this.containerDamage = containerDamage;
    }

    public ContainerShipowners getContainerShipowners() {
        return containerShipowners;
    }

    public void setContainerShipowners(ContainerShipowners containerShipowners) {
        this.containerShipowners = containerShipowners;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                containerShipowners == container.containerShipowners &&
                Objects.equals(user, container.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, noContainer, containerNoPin, containerType, containerDamage, containerShipowners, user);
    }
}
