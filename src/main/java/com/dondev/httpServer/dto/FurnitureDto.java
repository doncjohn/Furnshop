package com.dondev.httpServer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FurnitureDto {
    // Fields
    private String furnitureName;
    private String category;
    private int stock;
    private Float price;
    private String status;

    // Empty Constructor
    public FurnitureDto() {
    }

    // Constructor with All Fields
    public FurnitureDto(String furnitureName, String category, int stock, Float price, String status) {
        this.furnitureName = furnitureName;
        this.category = category;
        this.stock = stock;
        this.price = price;
        this.status = status;
    }
}
