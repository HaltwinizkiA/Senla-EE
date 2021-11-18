package com.senla.haltvinizki.entity.history;

import com.senla.haltvinizki.entity.product.Product;
import com.senla.haltvinizki.entity.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class History {
    @Column(name = "sellingPrice")
    private Double sellingPrice;

    @Column(name = "sellingDate")
    private Date sellingDate;

    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private User customer;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public History(double sellingPrice, Date sellingDate, Product product, User customer, int id) {
        this.sellingPrice = sellingPrice;
        this.sellingDate = sellingDate;
        this.product = product;
        this.customer = customer;
        this.id = id;
    }

    public History() {
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setSellingDate(Date sellingDate) {
        this.sellingDate = sellingDate;
    }

    public Product getProductId() {
        return product;
    }

    public void setProductId(Product productId) {
        this.product = productId;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public void setId(int id) {
        this.id = id;
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
