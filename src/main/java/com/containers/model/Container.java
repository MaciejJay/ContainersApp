package com.containers.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.Set;

@Entity
public class Container {

    @Id
    private String containerIdNumber;
    private String containerType;
    private String containerShipOwner;


    public Container() {
    }

    public Container(String containerIdNumber, String containerType, String containerShipOwner) {
        this.containerIdNumber = containerIdNumber;
        this.containerType = containerType;
        this.containerShipOwner = containerShipOwner;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return Objects.equals(containerIdNumber, container.containerIdNumber) &&
                Objects.equals(containerType, container.containerType) &&
                Objects.equals(containerShipOwner, container.containerShipOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(containerIdNumber, containerType, containerShipOwner);
    }

    @Override
    public String toString() {
        return "Container{" +
                "containerIdNumber='" + containerIdNumber + '\'' +
                ", containerType='" + containerType + '\'' +
                ", containerShipOwner='" + containerShipOwner + '\'' +
                '}';
    }
}
