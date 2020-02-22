package com.containers.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class OrderDetails {

    @Id
    @GeneratedValue(generator = "orderDetailsSeq")
    @SequenceGenerator(name = "orderDetailsSeq", sequenceName = "order_details_seq", allocationSize = 1)
    private Long id;
    private boolean isIn;
    private String orderNumber;
    private String truckNumber;
    private String trailerNumber;
    private String wagonNumber;

    @OneToOne (targetEntity = ContainerDamage.class, fetch = FetchType.EAGER)
    private ContainerDamage containerDamage;

    public OrderDetails() {
    }

    public OrderDetails(boolean isIn, String orderNumber, String truckNumber, String trailerNumber, String wagonNumber, ContainerDamage containerDamage) {
        this.isIn = isIn;
        this.orderNumber = orderNumber;
        this.truckNumber = truckNumber;
        this.trailerNumber = trailerNumber;
        this.wagonNumber = wagonNumber;
        this.containerDamage = containerDamage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getIsIn() {
        return isIn;
    }



    public void setIn(boolean in) {
        isIn = in;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public String getTrailerNumber() {
        return trailerNumber;
    }

    public void setTrailerNumber(String trailerNumber) {
        this.trailerNumber = trailerNumber;
    }

    public String getWagonNumber() {
        return wagonNumber;
    }

    public void setWagonNumber(String wagonNumber) {
        this.wagonNumber = wagonNumber;
    }

    public ContainerDamage getContainerDamage() {
        return containerDamage;
    }

    public void setContainerDamage(ContainerDamage containerDamage) {
        this.containerDamage = containerDamage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetails)) return false;
        OrderDetails that = (OrderDetails) o;
        return isIn == that.isIn &&
                Objects.equals(id, that.id) &&
                Objects.equals(orderNumber, that.orderNumber) &&
                Objects.equals(truckNumber, that.truckNumber) &&
                Objects.equals(trailerNumber, that.trailerNumber) &&
                Objects.equals(wagonNumber, that.wagonNumber) &&
                Objects.equals(containerDamage, that.containerDamage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isIn, orderNumber, truckNumber, trailerNumber, wagonNumber, containerDamage);
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", isIn=" + isIn +
                ", orderNumber=" + orderNumber +
                ", truckNumber='" + truckNumber + '\'' +
                ", trailerNumber='" + trailerNumber + '\'' +
                ", wagonNumber='" + wagonNumber + '\'' +
                ", containerDamage=" + containerDamage +
                '}';
    }
}
