package com.senla.haltvinizki.entity.history;

import com.senla.haltvinizki.entity.product.Product;
import com.senla.haltvinizki.entity.user.User;

import java.util.Date;

public class History {
    private final double sellingPrice;
    private final Date sellingDate;
    private final int productId;
    private final int customerId;
    private final int id;

    public History(double sellingPrice, Date sellingDate, int productId, int customerId, int id) {
        this.sellingPrice = sellingPrice;
        this.sellingDate = sellingDate;
        this.productId = productId;
        this.customerId = customerId;
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getId() {
        return id;
    }

    public double getSellingPrice() {
        return sellingPrice;

    }

    public Date getSellingDate() {
        return sellingDate;
    }
}
