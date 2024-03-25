package com.leynnnnnn.skid;

public class HomePageGridItem {
    int image;
    String type;
    String weight;

    public HomePageGridItem(int image, String type, String weight) {
        this.image = image;
        this.type = type;
        this.weight = weight;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
