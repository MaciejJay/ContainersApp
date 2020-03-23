package com.containers.service;

import com.containers.model.Container;
import com.containers.model.ContainerForm;
import com.containers.model.User;
import com.containers.repository.ContainerFormRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ContainerFormServiceTest {

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
    private ContainerFormService sut;
    @Autowired
    private ContainerFormRepository repository;

    @Test
    @Transactional
    public void shouldAddNewContainerForms() {
        //given
        ContainerForm newContainerForm = new ContainerForm(7L, null, user("wichni"), LocalDate.now());

        //when
        ContainerForm actual = sut.saveContainerForm(newContainerForm);

        //then
        assertThat(actual.getId()).isEqualTo(7L);
        assertThat(repository.getOne(actual.getId())).isNotNull();
    }

    @Test
    @Transactional
    public void shouldUpdateContainerForm() {
        //given
        ContainerForm updateContainerForm = new ContainerForm(1L, null, user("przydan"), LocalDate.now());

        //when
        ContainerForm actual = sut.saveContainerForm(updateContainerForm);

        //then
        assertThat(actual.getUser().getUsername()).isEqualTo("przydan");
        assertThat(actual.getAddDate()).isEqualTo(LocalDate.now());
    }
}
