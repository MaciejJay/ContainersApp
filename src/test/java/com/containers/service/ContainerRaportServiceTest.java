package com.containers.service;

import com.containers.model.Container;
import com.containers.model.ContainerRaport;
import com.containers.model.User;
import com.containers.repository.ContainerRaportRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ContainerRaportServiceTest {

    private User user(String username) {
        User user = new User();
        user.setUsername(username);
        return user;
    }

    private Container container(String containerIdNumber) {
        Container container = new Container();
        container.setContainerIdNumber(containerIdNumber);
        return container;
    }

    @Autowired
    private ContainerRaportService sut;
    @Autowired
    private ContainerRaportRepository repository;

//    @Test
//    public void shouldFindAllContainerForms() {
//        //when
//        Set<ContainerRaport> actual = sut.findAllContainerRapports();
//
//        //then
//        assertThat(actual.size()).isEqualTo(6);
//    }

    @Test
    @Transactional
    public void shouldAddNewContainerForms() {
        //given
        ContainerRaport newContainerRaport = new ContainerRaport(null, user("wichni"), LocalDate.now());

        //when
        ContainerRaport actual = sut.saveContainerRaport(newContainerRaport);

        //then
        assertThat(actual.getId()).isEqualTo(7L);
        assertThat(repository.getOne(actual.getId())).isNotNull();
    }

    @Test
    @Transactional
    public void shouldUpdateContainerForm() {
        //given
        ContainerRaport updateContainerRaport = new ContainerRaport(null, user("przydan"), LocalDate.now());

        //when
        ContainerRaport actual = sut.saveContainerRaport(updateContainerRaport);

        //then
        assertThat(actual.getUser().getUsername()).isEqualTo("przydan");
        assertThat(actual.getAddDate()).isEqualTo(LocalDate.now());
    }

    @Test
    @Transactional // TODO: ojoooj error bez tranzakcji
    void findAllContainerRapports() {
        // when
        Set<ContainerRaport> actual = sut.findAllContainerRapports("MRKU 9875432");
        // then
        actual.forEach(System.out :: println);
        assertThat(actual.size()).isEqualTo(3);
    }
}
