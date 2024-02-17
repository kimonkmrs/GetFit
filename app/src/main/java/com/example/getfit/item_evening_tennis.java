package com.example.getfit;

public class item_evening_tennis {
    String name;
    int image;
    private String url;

    public item_evening_tennis(String name, int image,String url) {
        this.name = name;
        this.image = image;
        this.url=url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
