package com.containers.utilities.pdf;

import com.containers.model.*;
import com.containers.repository.ContainerDamageRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class AppPdfWriter {

private ContainerDamageRepository repository;

    public AppPdfWriter(ContainerDamageRepository repository) {
        this.repository = repository;
    }

//TODO uncomment Spring needs it, delete static
//    private static HeaderCreator creator= new HeaderCreator();
//    public AppPdfWriter(HeaderCreator creator) {
//        this.creator = creator;
//    }

    Set<String> allDamages = new HashSet<>() {{
       add("Bent");
       add("Broken");
       add("Cracked");
       add("Hole");
       add("Missing");
       add("Bruise");
       add("Cut");
       add("Dent");
       add("Loose");
       add("Rusty");
    }};


    public ContainerDamage getOne(){
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

            //add sections to document
            doc.add(headerSection);
            doc.add(titleParagraph);


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
}