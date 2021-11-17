package com.senla.haltvinizki.entity.productCofniguration;

import javax.persistence.*;

@Entity
@Table(name = "productconfig")
public class ProductConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "maxprice")
    private float maxPrice;

    @Column(name = "productid")
    private int productId;

    @Column(name = "minprice")
    private float minPrice;

    @Column(name = "pricestep")
    private float priceStep;

    @Column(name = "frequency")
    private int frequency;

    public ProductConfiguration() {
    }

    public ProductConfiguration(int id, float maxPrice, int productId, float minPrice, float priceStep, int frequency) {
        this.id = id;
        this.maxPrice = maxPrice;
        this.productId = productId;
        this.minPrice = minPrice;
        this.priceStep = priceStep;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public int getProductId() {
        return productId;
    }

    public Float getMinPrice() {
        return minPrice;
    }

    public Float getPriceStep() {
        return priceStep;
    }

    public int getFrequency() {
        return frequency;
    }


}
