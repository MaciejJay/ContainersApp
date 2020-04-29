package com.containers.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@EqualsAndHashCode(exclude = {"reports"})
public class Container {

    @Id
    private String containerIdNumber;
    private String containerType;
    private String containerShipOwner;

    @OneToMany(targetEntity = Report.class,
            fetch = LAZY,
            cascade = ALL)
    private Set<Report> reports = new HashSet<>();

    public void addReport(Report report) {
        if (report == null) {
            reports = Collections.emptySet();
        } else {
            reports.add(report);
        }
    }
}
