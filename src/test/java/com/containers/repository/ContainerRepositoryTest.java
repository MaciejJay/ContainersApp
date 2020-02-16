package com.containers.repository;

import com.containers.model.Container;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ContainerRepositoryTest {

    @Autowired
    private ContainerRepository sut;

    @Test
    public void shouldReturnOptionalOfUsersByUserNames() {
        // when
        Optional<Container> actual = sut.findByNoContainer("APMU7236487");

        // then
        assertThat(actual).isPresent();
    }

}