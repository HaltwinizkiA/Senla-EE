package com.senla.haltvinizki.entity.category;


import com.senla.haltvinizki.entity.product.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@NamedEntityGraph(name = "category-product", attributeNodes = @NamedAttributeNode("products"))
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products;

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
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


}
