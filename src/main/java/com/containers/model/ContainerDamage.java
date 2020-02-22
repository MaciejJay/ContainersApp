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

    @Enumerated(EnumType.STRING)
    private StatusEnum containerStatus;
    private String description;
    private String PIN;

    @ManyToOne(targetEntity = Container.class)
    private Container container;

    @OneToMany(targetEntity = Image.class, fetch = FetchType.EAGER)
    private Set<Image> images;

    @ElementCollection(targetClass = DamageTypeEnum.class)
    @CollectionTable(name = "damage_type_mapping",
            joinColumns = @JoinColumn(name = "damage_id"))
    @Enumerated(EnumType.STRING)
    private Set<DamageTypeEnum> typeEnums = new HashSet<>();

    @ManyToOne(targetEntity = User.class)
    private User user;

    public ContainerDamage(LocalDate addDate, StatusEnum containerStatus, String description, String PIN, Container container, Set<Image> images, Set<DamageTypeEnum> typeEnums, User user) {
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


    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public Set<DamageTypeEnum> getTypeEnums() {
        return typeEnums;
    }

    public void setTypeEnums(Set<DamageTypeEnum> typeEnums) {
        this.typeEnums = typeEnums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContainerDamage)) return false;
        ContainerDamage that = (ContainerDamage) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(addDate, that.addDate) &&
                containerStatus == that.containerStatus &&
                Objects.equals(description, that.description) &&
                Objects.equals(PIN, that.PIN) &&
                Objects.equals(container, that.container) &&
                Objects.equals(images, that.images) &&
                Objects.equals(typeEnums, that.typeEnums) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addDate, containerStatus, description, PIN, container, images, typeEnums, user);
    }
}
