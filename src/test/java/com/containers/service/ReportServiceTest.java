package com.containers.service;

import com.containers.model.Container;
import com.containers.model.User;
import com.containers.repository.ReportRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ReportServiceTest {

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
    private ContainerReportService sut;
    @Autowired
    private ReportRepository repository;

    @Test
    @Transactional
    public void shouldAddNewContainerForms() {
        // given

        // when

        // then
    }

    @Test
    @Transactional
    public void shouldUpdateContainerForm() {
        // given

        // when

        // then
    }
}
