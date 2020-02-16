package com.containers.model;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class Image {

    @Id
    @GeneratedValue(generator = "imageSeq")
    @SequenceGenerator(name = "imageSeq", sequenceName = "image_seq", allocationSize = 1)
    private Long id;
//    private String url;
    private Side side;
    @Lob
    private Blob image;

    public Image() {
    }

    public Image(Side side, Blob image) {
        this.side = side;
        this.image = image;
    }

    public Image(Long id, Side side, Blob image) {
        this.id = id;
        this.side = side;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}
