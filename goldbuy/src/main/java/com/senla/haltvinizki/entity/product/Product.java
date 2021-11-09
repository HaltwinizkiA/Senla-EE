package com.senla.haltvinizki.entity.product;

import com.senla.haltvinizki.entity.category.Category;

import java.util.Date;

public class Product {
    private final int id;
    private final String name;
    private final Date addedDate;
    private final int userId;
    private final int categoryId;
    private final String status;
    private final double price;

    public Product(int id, String name, Date addedDate, int userId, int categoryId, String status, double price) {
        this.id = id;
        this.name = name;
        this.addedDate = addedDate;
        this.userId = userId;
        this.categoryId = categoryId;
        this.status = status;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public int getUserId() {
        return userId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }
}
