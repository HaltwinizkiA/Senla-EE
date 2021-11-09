package com.senla.haltvinizki.entity.productCofniguration;

public class ProductConfiguration {
    private final int id;
    private final float maxPrice;
    private final int productId;
    private final float minPrice;
    private final float priceStep;
    private final int frequency;

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

    public ProductConfiguration(int id, float maxPrice, int productId, float minPrice, float priceStep, int frequency) {
        this.id = id;
        this.maxPrice = maxPrice;
        this.productId = productId;
        this.minPrice = minPrice;
        this.priceStep = priceStep;
        this.frequency = frequency;
    }


}
