package com.senla.haltvinizki.entity;

import com.senla.haltvinizki.configuration.GraphConfiguration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products")
@NamedEntityGraph(name = GraphConfiguration.PRODUCT_CATEGORY, attributeNodes = @NamedAttributeNode("category"))
@NamedEntityGraph(name = GraphConfiguration.PRODUCT_USER, attributeNodes = @NamedAttributeNode("user"))
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    public void setPrice(Double price) {
        this.price = price;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userid")
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId")
    private Category category;

    @Column(name = "name")
    private String name;

    @Column(name = "addedDate")
    private Date addedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "price")
    private Double price;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
