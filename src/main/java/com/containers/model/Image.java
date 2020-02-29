package com.containers.model;


import javax.persistence.*;
import java.sql.Blob;


@Entity
public class Image {

    @Id
    @GeneratedValue(generator = "imageSeq")
    @SequenceGenerator(name = "imageSeq", sequenceName = "image_seq", allocationSize = 1)
    private Long id;
    private String url;
    @Lob
    private Blob image;

    public Image() {
    }
}
