package com.containers.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Entity
@Data
public class Shipowner {
    // examples: MSC, MAERSK, COSCO, APL, HAPAG

    @Id
    @GeneratedValue(generator = "ShipownerSeq")
    @SequenceGenerator(name = "ShipownerSeq", sequenceName = "Shipowner_seq", allocationSize = 1)
    private Long id;
    private String shortName;
    private String fullName;
    private String prefix;

    @OneToMany(targetEntity = Container.class,
            fetch = EAGER,
            cascade = ALL)
    private Set<Container> containers;

    public Shipowner() {
    }

}
