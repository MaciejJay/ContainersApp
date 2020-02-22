package com.containers.utilities.pdf;

import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.IOException;

public class HeaderCreator {

    //TODO delete static
    public static PdfPTable getHeader() throws BadElementException, IOException {
        return getHeaderSection();
    }

    private static PdfPTable getHeaderSection() throws BadElementException, IOException {
        float[] relativeWidths = {30F, 30F, 80F};

        PdfPTable headerSection = new PdfPTable(relativeWidths);

        Image image = getLogo();

        String headerText = getHeaderText();

        Phrase phrase = setHeaderTextFont(headerText);

        PdfPCell cell1= new PdfPCell();
        cell1.setImage(image);
        cell1.setFixedHeight(50F);

        PdfPCell cell2= new PdfPCell(new PdfPTable(new float[]{10F}));

        PdfPCell cell3= new PdfPCell(phrase);

        cell1.setVerticalAlignment(Element.ALIGN_TOP);
        cell3.setVerticalAlignment(Element.ALIGN_CENTER);

        headerSection.addCell(cell1).setBorder(Rectangle.BOTTOM);
        headerSection.addCell(cell2).setBorder(Rectangle.BOTTOM);
        headerSection.addCell(cell3).setBorder(Rectangle.BOTTOM);

        return headerSection;
    }

    private static Phrase setHeaderTextFont(String headerText) {
        return new Phrase(headerText, new Font(Font.FontFamily.TIMES_ROMAN, 8, 0, BaseColor.BLACK ));
    }

    private static String getHeaderText() {
        return "Loconi Intermodal S.A. z siedziba w Gdyni, ul. Hutnicza 2, 81-212\n" +
                "KRS 0000387523, NIP 958-165-05-13, REGON 221235901\n" +
                "Wysokosc kapitalu zakladowego: 1 754 500,00 zl. \n" +
                "Wysokosc kapitalu wplaconego: 1 600 600,00 zl. \n";
    }

    private static Image getLogo() throws BadElementException, IOException {
        return Image.getInstance("src/main/resources/pdf/loconi_logo.jfif");
    }
}
