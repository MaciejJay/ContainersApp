package com.containers.utilities.xssf;

import com.containers.utilities.xssf.writer.XlsWriter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class XlsService {

    private XlsWriter xlsWriter;

    public XlsService(XlsWriter xlsWriter) {
        this.xlsWriter = xlsWriter;
    }

    @SneakyThrows
    public void runWriter() {
        xlsWriter.writeContainerToSheet();
    }
}
