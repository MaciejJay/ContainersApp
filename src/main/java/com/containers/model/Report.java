package com.containers.model;

import com.containers.model.formHelpers.ContainerNeeds;
import com.containers.model.formHelpers.ContainerState;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"damages"})
public class Report {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(targetEntity = Container.class,
            fetch = FetchType.LAZY)
    private @NonNull Container container;

    @OneToMany(targetEntity = Damage.class,
            fetch = LAZY)
    private Set<Damage> damages = new HashSet<>();

    @ManyToOne(targetEntity = User.class,
            fetch = FetchType.LAZY)
    private @NonNull User user;

    private @NonNull LocalDateTime addDate;

    @Column(unique = true)
    private @NonNull String containerNoPin;

    private @NonNull String inOut;
    private @NonNull LocalDate inOutDate;
    private @NonNull String orderNo;
    private @NonNull String lastName;
    private @NonNull String truckNo;
    private @NonNull String chassisNo;
    private @NonNull String wagonNo;
    private @NonNull String estimatedCostOfRepair;

    @Enumerated(EnumType.STRING)
    private @NonNull ContainerState containerState;

    @Enumerated(EnumType.STRING)
    private @NonNull ContainerNeeds containerNeeds;

    public void addDamage(Damage damage) {
        // TODO: 01.04.2020  
    }
}
