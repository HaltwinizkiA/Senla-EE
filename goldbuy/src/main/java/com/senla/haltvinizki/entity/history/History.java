package com.senla.haltvinizki.entity.history;

import com.senla.haltvinizki.entity.product.Product;
import com.senla.haltvinizki.entity.user.User;

import java.util.Date;

public class History {
    private final Double sellingPrice;
    private final Date sellingDate;
    private final Product product;
    private final User customerId;
    private final int id;

    public History(Double sellingPrice, Date sellingDate, Product product, User customerId, int id) {
        this.sellingPrice = sellingPrice;
        this.sellingDate = sellingDate;
        this.product = product;
        this.customerId = customerId;
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public User getCustomerId() {
        return customerId;
    }

    public int getId() {
        return id;
    }

    public Double getSellingPrice() {
        return sellingPrice;

    }

    public Date getSellingDate() {
        return sellingDate;
    }
}
