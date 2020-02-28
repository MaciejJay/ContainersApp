package com.containers.utilities.xssf;

import com.containers.model.DTO.WorkEstimateExcelDTO;
import com.containers.utilities.xssf.writer.XlsWriter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class XlsxService {

    private XlsWriter xlsWriter;

    public XlsxService(XlsWriter xlsWriter) {
        this.xlsWriter = xlsWriter;
    }

    public void runWriter(WorkEstimateExcelDTO excelDTO) throws IOException, InvalidFormatException {
        xlsWriter.writeContainerToSheet(excelDTO);
    }
}
