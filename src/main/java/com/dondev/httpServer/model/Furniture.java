package com.dondev.httpServer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Furniture {
    private static final AtomicInteger counter = new AtomicInteger();
    private int furnitureId;
    private String furnitureName;
    private String category;
    private int stock;
    private Float price;
    private String status;

    // Empty Constructor
    public Furniture() {
    }

    // Constructor with fields
    public Furniture(String furnitureName, String category, int stock, Float price, String status) {
        this.furnitureId =counter.incrementAndGet();
        this.furnitureName = furnitureName;
        this.category = category;
        this.stock = stock;
        this.price = price;
        this.status = status;
    }
}
