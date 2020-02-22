package com.containers.utilities.xssf;

import com.containers.service.ContainerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class XlsServiceTest {

    @Autowired
    private XlsService sut;
    @Autowired
    private ContainerService containerService;

    @Test
    void shouldWriteValueInSheet() {
        // when
        sut.runWriter();
        // then
    }

}