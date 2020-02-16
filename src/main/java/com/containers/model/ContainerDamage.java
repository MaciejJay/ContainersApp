package com.containers.model;

import javax.persistence.*;
import java.time.LocalDate;
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

    @OneToMany(targetEntity = Image.class)
    private Set<Image> images;

    @OneToMany(targetEntity = DamageType.class)
    private Set<DamageType> damageTypes;

    @ManyToOne(targetEntity = User.class)
    private User user;

    @ManyToOne(targetEntity = Container.class)
    private Container container;

    public ContainerDamage() {
    }

    public ContainerDamage(LocalDate addDate, StatusEnum containerStatus, Container container, Set<Image> images,
                           Set<DamageType> damageTypes, String description, User user) {
        this.addDate = addDate;
        this.containerStatus = containerStatus;
        this.container = container;
        this.images = images;
        this.damageTypes = damageTypes;
        this.description = description;
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

    public Set<DamageType> getDamageTypes() {
        return damageTypes;
    }

    public void setDamageTypes(Set<DamageType> damageTypes) {
        this.damageTypes = damageTypes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContainerDamage that = (ContainerDamage) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(addDate, that.addDate) &&
                containerStatus == that.containerStatus &&
                Objects.equals(description, that.description) &&
                Objects.equals(container, that.container) &&
                Objects.equals(images, that.images) &&
                Objects.equals(damageTypes, that.damageTypes) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addDate, containerStatus, description, container, images, damageTypes, user);
    }
}
