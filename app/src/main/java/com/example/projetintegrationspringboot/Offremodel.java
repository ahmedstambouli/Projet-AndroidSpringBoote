package com.example.projetintegrationspringboot;

public class Offremodel {


    String title, description,image;

    public Offremodel() {
    }

    public Offremodel(String image, String niv, String desc) {
        this.image = image;
        this.title = niv;
        this.description = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
