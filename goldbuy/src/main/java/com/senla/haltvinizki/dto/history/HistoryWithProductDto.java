package com.senla.haltvinizki.dto.history;

import com.senla.haltvinizki.dto.product.ProductInfoDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class HistoryWithProductDto {
    private HistoryInfoDto history;
    private ProductInfoDto product;

    public ProductInfoDto getProduct() {
        return product;
    }

    public void setProduct(ProductInfoDto product) {
        this.product = product;
    }

    public HistoryInfoDto getHistory() {
        return history;
    }

    public void setHistory(HistoryInfoDto history) {
        this.history = history;
    }
}
