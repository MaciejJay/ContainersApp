package com.containers.utilities.pdf;

import com.containers.model.DamageTypeEnum;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.IOException;

public class DamageSection {

    private static PdfPTable getDamageTable() throws BadElementException, IOException {
        PdfPTable damageTypeTable = new PdfPTable((AppPdfWriter.allDamages.size())/2);

        for (DamageTypeEnum singleDamage : AppPdfWriter.allDamages) {

            PdfPTable singlePdfTable = new PdfPTable(2);

            if (!AppPdfWriter.containerDamage.add(singleDamage)){
                singlePdfTable.addCell(Image.getInstance("src/main/resources/pdf/checkMark.png"));
            } else singlePdfTable.addCell(DamageTypeEnum.valueOf(singleDamage.toString().toUpperCase()).getDamageSymbol());

            singlePdfTable.addCell(DamageTypeEnum.valueOf(singleDamage.toString().toUpperCase()).toString());
            damageTypeTable.addCell(singlePdfTable);
        }
        return damageTypeTable;
    }
}
