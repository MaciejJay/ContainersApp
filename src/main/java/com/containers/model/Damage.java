package com.containers.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Damage {

    @Id
    @GeneratedValue
    private Long id;
    private @NonNull String description;
    private @NonNull String image;
    @Enumerated(EnumType.STRING)
    private @NonNull DamageType damageType;
    @Enumerated(EnumType.STRING)
    private @NonNull Side side;

    @ManyToOne(targetEntity = Report.class)
    private Report report;

}
