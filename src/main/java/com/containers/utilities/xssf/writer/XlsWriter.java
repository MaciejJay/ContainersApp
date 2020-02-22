package com.containers.utilities.xssf.writer;

import com.containers.model.Container;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class XlsWriter {

    public XlsWriter() {
    }

    public void writeContainerToSheet(Container container) throws IOException, InvalidFormatException {
        OPCPackage pkg;
        String fileInputPath = "src/main/resources/xls/Work-Estimate.xlsx";
        try (FileInputStream in = new FileInputStream(new File(fileInputPath))) {
            pkg = OPCPackage.open(in);
        }
        try (XSSFWorkbook wb = new XSSFWorkbook(pkg)) {

            setLogo();
//            setTerminal(wb, TODO give string);
            setSerialNo(wb, container);
            setPrefix(wb, container);

            String fileOutputPath = "src/main/resources/xls/Work-Estimate-test.xlsx";
            try (OutputStream fileOut = new FileOutputStream(fileOutputPath)) {
                wb.write(fileOut);
            }
            pkg.close();
        }
    }

    // (rows)(columns)
    //(4-5) - (1-4)
    public void setLogo() {
        // TODO: 18.02.2020
    }

    //(7) - (1-4)
    public void setCustomer() {
        // TODO: 18.02.2020
    }

    //(9) - (1-2)
    public void setTerminal(XSSFWorkbook wb, Container container) {
        // TODO: 18.02.2020
    }

    //(9) - (3-4)
    public void setDateOfEstimate() {
        // TODO: 18.02.2020
    }

    //(11-23) - (1)
    public void setLocation() {

    }

    //(11-23) - (2)
    public void setComponent() {

    }

    //(11-23) - (3)
    public void setDamageCode() {

    }

    //(11-23) - (4)
    public void setRepairCode() {

    }

    //(23) - (2-4)
    public void setName() {

    }

    //(24) - (2-4)
    public void setDate() {

    }

    //(25-26) - (2-4)
    public void setSignature() {

    }

    //(6) - (7-8)
    public XSSFSheet setPrefix(XSSFWorkbook wb, Container container) {
        var sheet = wb.getSheetAt(0);
        var prefix = container.getPrefix();
        sheet.getRow(6).getCell(7).setCellValue(prefix);
        return sheet;
    }

    //(6) - (9-11)
    public XSSFSheet setSerialNo(XSSFWorkbook wb, Container container) {
        var sheet = wb.getSheetAt(0);
        var noContainer = container.getNoContainer();
        sheet.getRow(6).getCell(9).setCellValue(noContainer);
        return sheet;
    }

    //(6) - (12-13)
    public void setCD() {
        // TODO: 18.02.2020
    }

    //(8-9) - (7-9)
    public void setInOutDate() {
        // TODO: 18.02.2020
    }

    //(8) - (10-11)
    public void setContainerType() {
        // TODO: 18.02.2020
    }

    //(11-19) - (5-10)
    public void setDamageRepairDimensionsRemarks() {
        // TODO: 18.02.2020
        setHrs();
        setMaterialCost();
    }

    //(11-19) - (11)
    public void setHrs() {
        // TODO: 18.02.2020
    }

    //(11-19) - (12)
    public void setMaterialCost() {
        // TODO: 18.02.2020
    }

    //(21-22) - (5-10)
    public void setRepairHandling() {
        // TODO: 18.02.2020
        setRepairHrs();
        setRepairMaterialCost();
    }

    //(20-22) - (11)
    public void setRepairHrs() {
        // TODO: 18.02.2020
    }

    //(20-22) - (12)
    public void setRepairMaterialCost() {
        // TODO: 18.02.2020
    }



}
