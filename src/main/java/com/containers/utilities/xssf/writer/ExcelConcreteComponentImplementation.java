package com.containers.utilities.xssf.writer;

import com.containers.model.Container;
import lombok.SneakyThrows;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ExcelConcreteComponentImplementation implements ExcelComponent {

    @SneakyThrows
    @Override
    public void saveData(Container container) {
        // wczytanie pliku
        OPCPackage pkg;
        String fileInputPath = "src/main/resources/xls/Work-Estimate.xlsx";
        try (FileInputStream in = new FileInputStream(new File(fileInputPath))) {
            pkg = OPCPackage.open(in);
        }

        try (XSSFWorkbook wb = new XSSFWorkbook(pkg)) {
            // zapis pliku
            String fileOutputPath = "src/main/resources/xls/Work-Estimate-test.xlsx";
            try (OutputStream fileOut = new FileOutputStream(fileOutputPath)) {
                wb.write(fileOut);
            }
            pkg.close();
        }

    }
}
