package com.senla.haltvinizki.entity.productCofniguration;

import com.senla.haltvinizki.entity.product.Product;

public class ProductConfiguration {
    private final int id;
    private final Float maxPrice;
    private final Product product;
    private final Float minPrice;
    private final Float priceStep;
    private final int frequency;

    public ProductConfiguration(int id, Float maxPrice, Product product, Float minPrice, Float priceStep, int frequency) {
        this.id = id;
        this.maxPrice = maxPrice;
        this.product = product;
        this.minPrice = minPrice;
        this.priceStep = priceStep;
        this.frequency = frequency;
    }


}
