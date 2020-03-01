package com.containers.model;

import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(generator = "imageSeq")
    @SequenceGenerator(name = "imageSeq", sequenceName = "image_seq", allocationSize = 1)
    private Long id;
    private String url;

    public Image() {
    }
}
