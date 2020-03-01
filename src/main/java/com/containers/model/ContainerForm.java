package com.containers.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class ContainerForm {

    @Id
    @GeneratedValue(generator = "containerFormSeq")
    @SequenceGenerator(name = "containerFormSeq", sequenceName = "container_form_seq", allocationSize = 1)
    private Long id;
    private String containerNo;
    private String containerType;
    @ManyToOne(targetEntity = User.class)
    private User user;
    private LocalDate addDate;
    private String containerShipOwner;
    private String autoGeneratedPin;

    public ContainerForm() {
    }

    public ContainerForm(Long id, String containerNo, String containerType, User user, LocalDate addDate, String containerShipOwner, String autoGeneratedPin) {
        this.id = id;
        this.containerNo = containerNo;
        this.containerType = containerType;
        this.user = user;
        this.addDate = addDate;
        this.containerShipOwner = containerShipOwner;
        this.autoGeneratedPin = autoGeneratedPin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContainerNo() {
        return containerNo;
    }

    public void setContainerNo(String containerNo) {
        this.containerNo = containerNo;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }

    public String getContainerShipOwner() {
        return containerShipOwner;
    }

    public void setContainerShipOwner(String containerShipOwner) {
        this.containerShipOwner = containerShipOwner;
    }

    public String getAutoGeneratedPin() {
        return autoGeneratedPin;
    }

    public void setAutoGeneratedPin(String autoGeneratedPin) {
        this.autoGeneratedPin = autoGeneratedPin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContainerForm that = (ContainerForm) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(containerNo, that.containerNo) &&
                Objects.equals(containerType, that.containerType) &&
                Objects.equals(user, that.user) &&
                Objects.equals(addDate, that.addDate) &&
                Objects.equals(containerShipOwner, that.containerShipOwner) &&
                Objects.equals(autoGeneratedPin, that.autoGeneratedPin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, containerNo, containerType, user, addDate, containerShipOwner, autoGeneratedPin);
    }

    @Override
    public String toString() {
        return "ContainerForm{" +
                "id=" + id +
                ", containerNo='" + containerNo + '\'' +
                ", containerType='" + containerType + '\'' +
                ", user=" + user +
                ", addDate=" + addDate +
                ", containerShipOwner='" + containerShipOwner + '\'' +
                ", autoGeneratedPin='" + autoGeneratedPin + '\'' +
                '}';
    }
}
