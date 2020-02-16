package com.containers.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.EnumSet;
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
    @OneToMany(targetEntity = Image.class)
    private Set<Image> images;
    @ElementCollection
    private Set<DamageEnum> damages;
    private String description;

    public ContainerDamage() {
    }

    public ContainerDamage(LocalDate addDate, StatusEnum containerStatus, Set<Image> images,
                           EnumSet<DamageEnum> damages, String description) {
        this.addDate = addDate;
        this.containerStatus = containerStatus;
        this.images = images;
        this.damages = damages;
        this.description = description;
    }

    public ContainerDamage(Long id, LocalDate addDate, StatusEnum containerStatus,
                           Set<Image> images, EnumSet<DamageEnum> damages, String description) {
        this.id = id;
        this.addDate = addDate;
        this.containerStatus = containerStatus;
        this.images = images;
        this.damages = damages;
        this.description = description;
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

    public Set<DamageEnum> getDamages() {
        return damages;
    }

    public void setDamages(EnumSet<DamageEnum> damages) {
        this.damages = damages;
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
                Objects.equals(images, that.images) &&
                Objects.equals(damages, that.damages) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addDate, containerStatus, images, damages, description);
    }

    @Override
    public String toString() {
        return "ContainerDamage{" +
                "id=" + id +
                ", addDate=" + addDate +
                ", containerStatus=" + containerStatus +
                ", images=" + images +
                ", damages=" + damages +
                ", description='" + description + '\'' +
                '}';
    }
}
