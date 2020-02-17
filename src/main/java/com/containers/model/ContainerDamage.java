package com.containers.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class ContainerDamage {

    @Id
    @GeneratedValue(generator = "damageSeq")
    @SequenceGenerator(name = "damageSeq",
            sequenceName = "damage_seq", allocationSize = 1)
    private Long id;
    private LocalDate addDate;
    private StatusEnum containerStatus;
    private String description;

    @ManyToOne(targetEntity = Container.class)
    private Container container;

    @OneToMany(targetEntity = Image.class, fetch = FetchType.EAGER)
    private Set<Image> images;

    @ElementCollection
    private Set<DamageTypeEnum> typeEnums = new HashSet<>();

    @ManyToOne(targetEntity = User.class)
    private User user;

    public ContainerDamage() {
    }

    public ContainerDamage(LocalDate addDate, StatusEnum containerStatus, String description, Container container, Set<Image> images, Set<DamageTypeEnum> typeEnums, User user) {
        this.addDate = addDate;
        this.containerStatus = containerStatus;
        this.description = description;
        this.container = container;
        this.images = images;
        this.typeEnums = typeEnums;
        this.user = user;
    }

    //    public ContainerDamage(LocalDate addDate, StatusEnum containerStatus, Container container, Set<Image> images,
//                           Set<DamageType> damageTypes, String description, User user) {
//        this.addDate = addDate;
//        this.containerStatus = containerStatus;
//        this.container = container;
//        this.images = images;
//        this.damageTypes = damageTypes;
//        this.description = description;
//        this.user = user;
//    }


    public void setId(Long id) {
        this.id = id;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public Set<DamageTypeEnum> getType() {
        return typeEnums;
    }

    public void setType(Set<DamageTypeEnum> type) {
        this.typeEnums = type;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Container getContainerId() {
        return container;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }

    public StatusEnum getContainerStatus() {
        return containerStatus;
    }

    public void setContainerStatus(StatusEnum containerStatus) {
        this.containerStatus = containerStatus;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

//    public Set<DamageType> getDamageTypes() {
//        return damageTypes;
//    }
//
//    public void setDamageTypes(Set<DamageType> damageTypes) {
//        this.damageTypes = damageTypes;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ContainerDamage that = (ContainerDamage) o;
//        return Objects.equals(id, that.id) &&
//                Objects.equals(addDate, that.addDate) &&
//                containerStatus == that.containerStatus &&
//                Objects.equals(description, that.description) &&
//                Objects.equals(container, that.container) &&
//                Objects.equals(images, that.images) &&
//                Objects.equals(damageTypes, that.damageTypes) &&
//                Objects.equals(user, that.user);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, addDate, containerStatus, description, container, images, damageTypes, user);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContainerDamage)) return false;
        ContainerDamage that = (ContainerDamage) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(addDate, that.addDate) &&
                containerStatus == that.containerStatus &&
                Objects.equals(description, that.description) &&
                Objects.equals(container, that.container) &&
                Objects.equals(images, that.images) &&
                Objects.equals(typeEnums, that.typeEnums) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addDate, containerStatus, description, container, images, typeEnums, user);
    }

    @Override
    public String toString() {
        return "ContainerDamage{" +
                "id=" + id +
                ", addDate=" + addDate +
                ", containerStatus=" + containerStatus +
                ", description='" + description + '\'' +
                ", container=" + container +
                ", images=" + images +
                ", damageType=" + typeEnums +
                ", user=" + user +
                '}';
    }
}
