package com.containers.utilities.pdf;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.IOException;

public class OrderDetailsSection {

    public static PdfPTable getOrderDetailsSection() {
        PdfPTable table = new PdfPTable(3);
        PdfPTable table1 = new PdfPTable(1);
        PdfPTable inOutTable = new PdfPTable(4);
        Image instance = null;
        try {
            instance = Image.getInstance("src/main/resources/pdf/checkMark.png");
        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (AppPdfWriter.details.getIsIn()) {
            inOutTable.addCell(instance);
            inOutTable.addCell("In");
            inOutTable.addCell("");
            inOutTable.addCell("Out");
        } else {
            inOutTable.addCell("");
            inOutTable.addCell("In");
            inOutTable.addCell(instance);
            inOutTable.addCell("Out");
        }
        table1.addCell(inOutTable);
        table1.addCell(String.valueOf(new Chunk("Data/date:" + AppPdfWriter.damage.getAddDate().toString(), new Font(Font.FontFamily.TIMES_ROMAN, 8, 1))));
        table.addCell(table1);

        PdfPTable table2 = new PdfPTable(1);
        table2.addCell("Numer kontenera\n" +
                "Container number");
        table2.addCell(AppPdfWriter.container.getNoContainer());
        table.addCell(table2);

        PdfPTable table3 = new PdfPTable(1);
        table3.addCell("Typ kontenera\nContainer type");
        table3.addCell(AppPdfWriter.container.getContainerType());
        table.addCell(table3);
        return table;
    }
}
