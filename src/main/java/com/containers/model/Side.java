package com.containers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Objects;

@Entity
public class Side {

    @Id
    @GeneratedValue(generator = "sideSeq")
    @SequenceGenerator(name = "sideSeq", sequenceName = "side_seq", allocationSize = 1)
    private Long id;
    private String side;

    public Side() {
    }

    public Side(Long id, String side) {
        this.id = id;
        this.side = side;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Side side1 = (Side) o;
        return Objects.equals(id, side1.id) &&
                Objects.equals(side, side1.side);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, side);
    }

    @Override
    public String toString() {
        return "Side{" +
                "id=" + id +
                ", side='" + side + '\'' +
                '}';
    }
}
