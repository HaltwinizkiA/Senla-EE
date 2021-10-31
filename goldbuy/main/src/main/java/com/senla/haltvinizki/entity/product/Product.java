package com.senla.haltvinizki.entity.product;

import com.senla.haltvinizki.entity.category.Category;
import com.senla.haltvinizki.entity.user.User;

import java.util.Date;

public class Product {
    private final int id;
    private final String name;
    private final Date addedDate;
    private final User user;
    private final Category category;
    private final String status;
    private final double price;


    public Product(int id, String name, Date addedDate, User user, Category category, String status, double price) {
        this.id = id;
        this.name = name;
        this.addedDate = addedDate;
        this.user = user;
        this.category = category;
        this.status = status;
        this.price = price;
    }
}
