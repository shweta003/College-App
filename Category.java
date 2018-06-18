package com.mcc.myapplication;


public class Category {
    int id;
    String name;
int img_id;
    public Category(int id, String name, int img) {
        super();
        this.id = id;
        this.name = name;
        this.img_id=img;
    }

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }
}
