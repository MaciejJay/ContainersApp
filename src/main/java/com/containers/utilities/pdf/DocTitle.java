package com.containers.utilities.pdf;

import com.itextpdf.text.*;

public class DocTitle {

    private static String title= "Ocena stanu technicznego kontenera / equipment interchange receipt";

    public static Paragraph getTitle() {
        return titleDetails();
    }

    private static Paragraph titleDetails() {

        Chunk titleChunk = new Chunk(title, FontFactory.getFont(FontFactory.TIMES_ROMAN, "UTF-8", 10, 1, BaseColor.BLACK));

        Phrase phrase = new Phrase(titleChunk);

        Paragraph titleParagraph = new Paragraph();
        titleParagraph.setSpacingAfter(10F);
        titleParagraph.add(phrase);
        titleParagraph.setAlignment(Element.ALIGN_CENTER);
        return titleParagraph;
    }
}
