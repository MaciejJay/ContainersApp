package com.containers.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Damage {

    @Id
    @GeneratedValue(generator = "damageSeq")
    @SequenceGenerator(name = "damageSeq", sequenceName = "damage_seq", allocationSize = 1)
    private Long id;
    private String description;
    private String image;
    @Enumerated(EnumType.STRING)
    private DamageType damageType;
    @Enumerated(EnumType.STRING)
    private Side side;

    @ManyToOne(targetEntity = ContainerRaport.class)
    private ContainerRaport containerRaport;

    public Damage() {
    }

    public Damage(Long id, String description, String image, DamageType damageType, Side side, ContainerRaport containerRaport) {
        this.id = id;
        this.description = description;
        this.image = image;
        this.damageType = damageType;
        this.side = side;
        this.containerRaport = containerRaport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public ContainerRaport getContainerRaport() {
        return containerRaport;
    }

    public void setContainerRaport(ContainerRaport containerRaport) {
        this.containerRaport = containerRaport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Damage damage = (Damage) o;
        return Objects.equals(id, damage.id) &&
                Objects.equals(description, damage.description) &&
                Objects.equals(image, damage.image) &&
                Objects.equals(damageType, damage.damageType) &&
                side == damage.side &&
                Objects.equals(containerRaport, damage.containerRaport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, image, damageType, side, containerRaport);
    }

    @Override
    public String toString() {
        return "Damage{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", damageType=" + damageType +
                ", side=" + side +
                ", containerRaport=" + containerRaport +
                '}';
    }
}
