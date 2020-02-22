package com.containers.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.*;

@Entity
public class ContainerShipowner {
    // examples: MSC, MAERSK, COSCO, APL, HAPAG

    @Id
    @GeneratedValue(generator = "ContainerShipownerSeq")
    @SequenceGenerator(name = "ContainerSeq", sequenceName = "Container_shipowner_seq", allocationSize = 1)
    private Long id;
    private String shortName;
    private String fullName;

    @OneToMany(targetEntity = Container.class,
            fetch = EAGER,
            cascade = ALL)
    private Set<Container> containers;

    public ContainerShipowner() {
    }

    public Long getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Container> getContainers() {
        return containers;
    }

    public void setContainers(Set<Container> containers) {
        this.containers = containers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContainerShipowner that = (ContainerShipowner) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(shortName, that.shortName) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(containers, that.containers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shortName, fullName, containers);
    }

    @Override
    public String toString() {
        return "ContainerShipowner{" +
                "id=" + id +
                ", shortName='" + shortName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", containers=" + containers +
                '}';
    }
}
