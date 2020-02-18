package com.containers.utilities.xls;

import com.containers.model.Container;
import com.containers.service.ContainerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class XlsServiceTest {

    @Autowired
    private XlsService sut;
    @Autowired
    private ContainerService containerService;

    @Test
    void shouldWriteValueInSheet() {
        // given
        var actual = containerService.findContainerById("236487");
        // when
        sut.runWriter(actual);
        // then

    }

}