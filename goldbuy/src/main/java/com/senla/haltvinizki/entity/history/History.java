package com.senla.haltvinizki.entity.history;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class History {
    @Column(name = "sellingprice")
    private double sellingPrice;

    @Column(name = "sellenigdate")
    private Date sellingDate;

    @Column(name = "productid")
    private int productId;

    @Column(name = "customerid")
    private int customerId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    public History(double sellingPrice, Date sellingDate, int productId, int customerId, int id) {
        this.sellingPrice = sellingPrice;
        this.sellingDate = sellingDate;
        this.productId = productId;
        this.customerId = customerId;
        this.id = id;
    }

    public History() {
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
