package com.containers.utilities.xssf.writer;

import com.containers.model.Container;
import com.containers.utilities.xssf.XlsxFacade;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class XlsWriter {

    private XlsxFacade xlsxFacade;

    public XlsWriter(XlsxFacade xlsxFacade) {
        this.xlsxFacade = xlsxFacade;
    }

    public void writeContainerToSheet() throws IOException, InvalidFormatException {
        OPCPackage pkg;
        String fileInputPath = "src/main/resources/xls/Work-Estimate.xlsx";
        try (FileInputStream in = new FileInputStream(new File(fileInputPath))) {
            pkg = OPCPackage.open(in);
        }
        try (XSSFWorkbook wb = new XSSFWorkbook(pkg)) {


            setLogo(wb, xlsxFacade.getLogo("loconi"));
            setSerialNo(wb, xlsxFacade.getContainerSerialNo("123456789"));
            setPrefix(wb, xlsxFacade.getShipownerPrefix(1L));

            String fileOutputPath = "src/main/resources/xls/Work-Estimate-test.xlsx";
            try (OutputStream fileOut = new FileOutputStream(fileOutputPath)) {
                wb.write(fileOut);
            }
            pkg.close();
        }
    }

    // (rows)(columns)
    //(4-5) - (1-4)
    public void setLogo(XSSFWorkbook wb, byte[] image) {
        int pictureIdx = wb.addPicture(image, Workbook.PICTURE_TYPE_JPEG);

        CreationHelper helper = wb.getCreationHelper();
        var sheet = wb.getSheetAt(0);

        // Create the drawing patriarch.  This is the top level container for all shapes.
        Drawing drawing = sheet.createDrawingPatriarch();

        //add a picture shape
        ClientAnchor anchor = helper.createClientAnchor();

        //set top-left corner of the picture,
        //subsequent call of Picture#resize() will operate relative to it
        anchor.setCol1(1);
        anchor.setRow1(4);
        Picture pict = drawing.createPicture(anchor, pictureIdx);

        //auto-size picture relative to its top-left corner
        pict.resize();
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
    public void setPrefix(XSSFWorkbook wb, String shipownerPrefix) {
        var sheet = wb.getSheetAt(0);
        sheet.getRow(6).getCell(7).setCellValue(shipownerPrefix);
    }

    //(6) - (9-11)
    public void setSerialNo(XSSFWorkbook wb, String containerSerialNo) {
        var sheet = wb.getSheetAt(0);
        sheet.getRow(6).getCell(9).setCellValue(containerSerialNo);
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
