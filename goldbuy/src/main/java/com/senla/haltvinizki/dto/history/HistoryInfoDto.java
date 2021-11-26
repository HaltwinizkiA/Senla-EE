package com.senla.haltvinizki.dto.history;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryInfoDto {
    private Long id;
    private Float sellingPrice;
    private Date sellingDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getSellingPrice() {
        return sellingPrice;

    }

    public void setSellingPrice(Float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Date getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(Date sellingDate) {
        this.sellingDate = sellingDate;
    }
}
