package com.senla.haltvinizki.entity.category;


public class Category {
    public void setId(int id) {
        this.id = id;
    }

    public Category() {
    }

    public void setName(String name) {
        this.name = name;
    }

    private  int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
