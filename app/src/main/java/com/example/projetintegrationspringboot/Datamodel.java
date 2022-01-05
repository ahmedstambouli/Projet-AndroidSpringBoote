package com.example.projetintegrationspringboot;

public class Datamodel {

    int image;
    String niv,desc;


    public Datamodel(int image, String niv, String desc) {
        this.image = image;
        this.niv = niv;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNiv() {
        return niv;
    }

    public void setNiv(String niv) {
        this.niv = niv;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
