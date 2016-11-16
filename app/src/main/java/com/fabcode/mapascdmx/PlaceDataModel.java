package com.fabcode.mapascdmx;

/**
 * Created by RGonzales on 11/15/2016.
 */

public class PlaceDataModel {

    private String name;
    private int image;
    private Coords coords;

    public PlaceDataModel(String name, int image, Coords coords) {
        this.name = name;
        this.image = image;
        this.coords = coords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Coords getCoords() {
        return coords;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }
}
