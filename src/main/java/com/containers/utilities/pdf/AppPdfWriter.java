package com.containers.utilities.pdf;

import com.containers.model.*;
import com.containers.repository.ContainerDamageRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

@Service
public class AppPdfWriter {

    private ContainerDamageRepository repository;

    public AppPdfWriter(ContainerDamageRepository repository) {
        this.repository = repository;
    }

    static Container container;
    static User user;
    static ContainerDamage damage;
    static Set<ContainerDamage> containerDamageSet = new HashSet<>();
    static OrderDetails details;
//TODO uncomment Spring needs it, delete static
//    private static HeaderCreator creator= new HeaderCreator();
//    public AppPdfWriter(HeaderCreator creator) {
//        this.creator = creator;
//    }

    static EnumSet<DamageTypeEnum> allDamages = EnumSet.allOf(DamageTypeEnum.class);

 /*   static Set<DamageTypeEnum> allDamages = new HashSet<>() {{
        add(DamageTypeEnum.HOLE);
        add(DamageTypeEnum.BRUISE);
        add(DamageTypeEnum.LOOSE);
        add(DamageTypeEnum.BENT);
        add(DamageTypeEnum.BROKEN);
        add(DamageTypeEnum.CRACKED);
        add(DamageTypeEnum.CUT);
        add(DamageTypeEnum.DENT);
        add(DamageTypeEnum.MISSING);
        add(DamageTypeEnum.RUSTY);
    }};*/

    static Set<DamageTypeEnum> containerDamage = new HashSet<>() {{
        add(DamageTypeEnum.HOLE);
        add(DamageTypeEnum.BRUISE);
        add(DamageTypeEnum.LOOSE);
    }};

    public ContainerDamage getOne() {
        return repository.getOne(1L);
    }


    public static void main(String[] args) {


        Document doc = new Document();
        PdfWriter docWriter = null;
        String outputFilePath = "src/main/resources/pdf/result.pdf";
        try {
            docWriter = PdfWriter.getInstance(doc, new FileOutputStream(outputFilePath));
            doc.open();
            //get all sections
            PdfPTable headerSection = HeaderCreator.getHeader();
            Paragraph titleParagraph = DocTitle.getTitle();


            damage = new ContainerDamage(LocalDate.now(), StatusEnum.CONTAINER_UNUSABLE, "Description", container, null, containerDamage, user);
            user = new User("Admin", "Adam", "Adminowy", "a@a.pl");
            containerDamageSet.add(damage);
            container = new Container("CNUM123", "PIN123", "40", containerDamageSet);
            details = new OrderDetails(true, "ONum123", "Pz123", "Pz321", "Wag123", damage);


            PdfPTable table = OrderDetailsSection.getOrderDetailsSection();
            table.setSpacingAfter(3F);

            PdfPTable damageTypeTable = getDamageTable();


            {
                doc.add(headerSection);
            }
            doc.add(titleParagraph);

            doc.add(table);

            doc.add(damageTypeTable);
            doc.close();

        } catch (Exception dex) {
            dex.printStackTrace();
        } finally {
            doc.close();
            if (docWriter != null) {
                docWriter.close();
            }
        }
    }

    private static PdfPTable getDamageTable() throws BadElementException, IOException {
        PdfPTable damageTypeTable = new PdfPTable((allDamages.size()) / 2);

        for (DamageTypeEnum singleDamage : allDamages) {

            PdfPTable singlePdfTable = new PdfPTable(2);

            if (!containerDamage.add(singleDamage)) {
                singlePdfTable.addCell(Image.getInstance("src/main/resources/pdf/checkMark.png"));
            } else
                singlePdfTable.addCell(DamageTypeEnum.valueOf(singleDamage.toString().toUpperCase()).getDamageSymbol());

            singlePdfTable.addCell(DamageTypeEnum.valueOf(singleDamage.toString().toUpperCase()).toString());
            damageTypeTable.addCell(singlePdfTable);
        }
        return damageTypeTable;
    }

}