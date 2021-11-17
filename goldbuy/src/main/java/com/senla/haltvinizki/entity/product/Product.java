package com.senla.haltvinizki.entity.product;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "addeddate")
    private Date addedDate;

    @Column(name = "userid")
    private int userId;

    @Column(name = "categoryid")
    private int categoryId;

    @Column(name = "status")
    private String status;

    @Column(name = "price")
    private double price;

    public Product() {
    }

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
