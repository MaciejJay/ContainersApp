package com.containers.service;

import com.containers.exceptions.ContainerNotFoundForShipownerException;
import com.containers.model.Container;
import com.containers.repository.ContainerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ContainerServiceTest {

    @Autowired
    private ContainerService sut;
    @Autowired
    private ContainerRepository containerRepository;

    @Test
    public void shouldReturnOptionalOfContainerByNoContainer() {
        // when
        Container actual = sut.findContainerById("APMU7236487");
        // then
        assertThat(actual).extracting(Container :: getNoContainer).isEqualTo("APMU7236487");
    }

    @Test
    void shouldFindAllContainers() {
        // when
        Set<Container> actual = sut.findAllContainers();
        // then
        assertThat(actual).size().isEqualTo(3);
    }

    @Test
    @Transactional
    void shouldSaveContainerInDB() {
        // given
        Container newContainer = new Container("APMU834795", "6574894", "40", null);
        // when
        Container actual = sut.saveContainer(newContainer);
        // then
        assertThat(newContainer.getNoContainer()).isEqualTo("APMU834795");
        assertThat(containerRepository.getOne(newContainer.getNoContainer())).isNotNull();

    }

    @Test
    @Transactional
    void shouldUpdateContainer() {
        // given
        Container updatedContainer = new Container("APMU7236423", "123456789", "40", null);
        // when
        Container actual = sut.updateContainer(updatedContainer);
        // then
        assertThat(actual).isEqualToComparingFieldByField(updatedContainer);
    }

    @Test
    void shouldFindByContainerShipowner_id() {
        // when
        Set<Container> actual = sut.findByContainersShipownerId(1L);
        // then
        assertThat(actual).hasSize(3);
    }

    //TODO: test - shouldThrowContainerNotFoundForShipownerException()

}