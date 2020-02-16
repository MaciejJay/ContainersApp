package com.containers.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class ContainerShipowner {
    // examples: MSC, MAERSK, COSCO, APL, HAPAG

    @Id
    @GeneratedValue(generator = "ContainerShipownerSeq")
    @SequenceGenerator(name = "ContainerSeq", sequenceName = "Container_shipowner_seq", allocationSize = 1)
    private Long id;
    private String prefix;
    private String shortName;
    private String fullName;

    @OneToMany(targetEntity = Container.class)
    private Set<Container> containers;

    public ContainerShipowner() {
    }

    public Long getId() {
        return id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
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
                Objects.equals(prefix, that.prefix) &&
                Objects.equals(shortName, that.shortName) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(containers, that.containers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prefix, shortName, fullName, containers);
    }
}
