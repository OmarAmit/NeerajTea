package com.lifeplaytrip.neerajtea.model;

/**
 * Created by LifePlayTrip on 5/30/2018.
 */

public class Catogary {
    private String cat_name;
    private int cat_id;
    private String cat_image;

    public Catogary(String cat_name, String cat_image, int cat_id) {
        this.cat_name = cat_name;
        this.cat_id = cat_id;
        this.cat_image = cat_image;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_image() {
        return cat_image;
    }

    public void setCat_image(String cat_image) {
        this.cat_image = cat_image;
    }
}
