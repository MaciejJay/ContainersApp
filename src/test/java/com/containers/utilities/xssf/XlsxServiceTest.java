package com.containers.utilities.xssf;

import com.containers.service.ContainerService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class XlsxServiceTest {

    @Autowired
    private XlsxService sut;
    @Autowired
    private ContainerService containerService;

//    @Test
//    void shouldWriteValueInSheet() throws IOException, InvalidFormatException {
//        // when
//        sut.runWriter(excelDTO);
//        // then
//    }

}