package com.containers.service;

import com.containers.model.Damage;
import com.containers.model.DamageType;
import com.containers.model.Side;
import com.containers.repository.DamageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DamageServiceTest {

    @Autowired
    private DamageService sut;
    @Autowired
    private DamageRepository repository;

    @Test
    @Transactional
    public void shouldReturnAllDamage() {
        //when
        Set<Damage> actual = sut.findAllDamage();
        //then
        assertThat(actual.size()).isEqualTo(1);
    }

    @Test
    @Transactional
    public void shouldAddNewDamageToContainer() {
        //given
        Damage newDamage = new Damage
                (7L, "Dziura w podlodze",
                        null, DamageType.HOLE, Side.CENTER, null);

        //when
        Damage addDamage = sut.saveContainerDamage(newDamage);
        //then
        assertThat(addDamage.getId()).isEqualTo(7);
        assertThat(repository.getOne(addDamage.getId())).isNotNull();
    }

    @Test
    @Transactional
    public void shouldUpdateContainerDamage() {
        //given
        Damage updateDamage = new Damage
                (3L, "Uszkodzony rygiel",
                        null, DamageType.BENT, Side.DOOR, null);
        //when

        Damage containerDamage = sut.saveContainerDamage(updateDamage);

        //then
        assertThat(containerDamage.getId()).isEqualTo(3);
        assertThat(repository.findById(3L)).hasValue(updateDamage);
    }
}