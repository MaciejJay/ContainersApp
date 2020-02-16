package com.containers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Objects;

@Entity
public class DamageType {

    @Id
    @GeneratedValue(generator = "damageSeq")
    @SequenceGenerator(name = "damageSeq", sequenceName = "damage_seq", allocationSize = 1)
    private Long id;
    private String damageType;

    public DamageType() {
    }

    public DamageType(String damageType) {
        this.damageType = damageType;
    }

    public Long getId() {
        return id;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damage) {
        this.damageType = damage;
    }

    @Override
    public String toString() {
        return "DamageEnum{" +
                "id=" + id +
                ", damage='" + damageType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DamageType that = (DamageType) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(damageType, that.damageType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, damageType);
    }
}
