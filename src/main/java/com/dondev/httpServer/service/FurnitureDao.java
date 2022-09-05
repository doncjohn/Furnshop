package com.dondev.httpServer.service;

import com.dondev.httpServer.dto.FurnitureDto;
import com.dondev.httpServer.model.ApiResponse;
import com.dondev.httpServer.model.Furniture;
import static com.dondev.httpServer.shared.Constants.*;

import java.util.ArrayList;
import java.util.List;

public class FurnitureDao {
    public static List<Furniture> furnitureList = new ArrayList<>();
    // Get Furniture
    public static ApiResponse getFurniture(){
        return new ApiResponse(STATUS_OK, DATA_GOT,furnitureList);
    }
    // Get Furniture By ID
    public static ApiResponse getFurnitureById(int id){
        Furniture data = fetchFurniture(id);
        if(data==null)
            return new ApiResponse(STATUS_NOT_FOUND, DATA_NOT_FOUND);
        return new ApiResponse(STATUS_OK, DATA_GOT,data);
    }
    // Get Furniture By Status
    public static ApiResponse getFurnitureByStatus(String status){
        List<Furniture> resList = new ArrayList<>();
        for (Furniture data : furnitureList)
            if(data.getStatus().equals(status))
                resList.add(data);
        return new ApiResponse(STATUS_OK, DATA_GOT,resList);
    }
    // Add Furniture
    public static ApiResponse addFurniture(FurnitureDto furniture){
        for (Furniture data : furnitureList)
            if (data.getFurnitureName().equals(furniture.getFurnitureName()))
                return new ApiResponse(STATUS_ON_CONFLICT, DATA_INSERT_CONFLICT);
        Furniture addData = new Furniture(furniture.getFurnitureName(),furniture.getCategory(),furniture.getStock(), furniture.getPrice(), furniture.getStatus());
        furnitureList.add(addData);
        return new ApiResponse(STATUS_CREATED, DATA_INSERTED);
    }
    // Update Furniture
    public static ApiResponse updateFurniture(int id,FurnitureDto furniture){
        Furniture data = fetchFurniture(id);
        if(data==null)
            return new ApiResponse(STATUS_NOT_FOUND, DATA_NOT_FOUND);
        if(furniture.getFurnitureName()!=null) data.setFurnitureName(furniture.getFurnitureName());
        if(furniture.getCategory()!=null) data.setCategory(furniture.getCategory());
        // Stock & Price null checking is not done properly
        if(furniture.getPrice()!=0) data.setPrice(furniture.getPrice());
        if(furniture.getStock()!=0) data.setStock(furniture.getStock());
        if(furniture.getStatus()!=null) data.setStatus(furniture.getStatus());
        return new ApiResponse(STATUS_OK, DATA_UPDATED);
    }
    // Delete Furniture
    public static ApiResponse deleteFurniture(int id){
        if(fetchFurniture(id)==null)
            return new ApiResponse(STATUS_NOT_FOUND, DATA_NOT_FOUND);
        id-=1;
        furnitureList.remove(id);
        return new ApiResponse(STATUS_OK, DATA_DELETED);
    }
    // Fetch Furniture if present
    public static Furniture fetchFurniture(int id){
        for (Furniture data : furnitureList)
            if(data.getFurnitureId()==id)
                return data;
        return null;
    }
}
