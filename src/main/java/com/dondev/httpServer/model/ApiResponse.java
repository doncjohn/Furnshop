package com.dondev.httpServer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(includeFieldNames = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    // Fields
    private int statusCode;
    private String message;
    private List<Furniture> furnitureList;
    private Furniture furniture;

    // Constructor
    public ApiResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
    // Constructor with Furniture List
    public ApiResponse(int statusCode, String message, List<Furniture> furnitureList) {
        this.statusCode = statusCode;
        this.message = message;
        this.furnitureList = furnitureList;
    }
    // Constructor with Furniture
    public ApiResponse(int statusCode, String message, Furniture furniture) {
        this.statusCode = statusCode;
        this.message = message;
        this.furniture = furniture;
    }
}
