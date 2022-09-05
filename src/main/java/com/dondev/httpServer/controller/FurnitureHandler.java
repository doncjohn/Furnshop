package com.dondev.httpServer.controller;

import java.util.*;
import java.io.IOException;

import com.dondev.httpServer.dto.FurnitureDto;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.dondev.httpServer.utils.Json;
import com.dondev.httpServer.model.ApiResponse;
import static com.dondev.httpServer.utils.Request.*;
import static com.dondev.httpServer.shared.Constants.*;
import static com.dondev.httpServer.service.FurnitureDao.*;
import static com.dondev.httpServer.validator.NumericValidator.isNumeric;

public class FurnitureHandler {
    public static class RootHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {
            try (he) {
                final String requestMethod = he.getRequestMethod().toUpperCase();
                final Map<String, String> queryParams = queryToMap(he.getRequestURI().getQuery());
                ObjectMapper objectMapper = new ObjectMapper();
                ObjectNode reqBody = (ObjectNode) requestBody(he);
                String[] fields = {"furnitureName", "category", "stock","price","status"};
                ApiResponse apiResponse = new ApiResponse(STATUS_INTERNAL_SERVER_ERROR,INTERNAL_SERVER_ERROR);

                switch (requestMethod) {
                    case METHOD_GET -> {
                        // Get All Furniture
                        if(queryParams==null) {
                            apiResponse = getFurniture();
                            break;
                        }
                        // Get Furniture By Status
                        if(queryParams.get("status")!=null)
                            apiResponse = getFurnitureByStatus(queryParams.get("status"));
                        // Get Furniture By ID
                        if(queryParams.get("id")!=null){
                            if (isNumeric(queryParams.get("id"))){
                                int id = Integer.parseInt(queryParams.get("id"));
                                apiResponse = getFurnitureById(id);
                            } else
                                apiResponse = new ApiResponse(STATUS_BAD_REQUEST, DATA_NOT_INT);
                        }
                    }

                    case METHOD_POST -> {
                        boolean format = reqBody==null;
                        for (String field: fields) {
                            format = format || reqBody.findValue(field) == null;
                        }
                        // Checks all fields are present
                        if(format)
                            apiResponse =  new ApiResponse(STATUS_BAD_REQUEST,BAD_REQUEST);
                        else {
                            try{
                                FurnitureDto data = objectMapper.readValue(reqBody.toString(), FurnitureDto.class);
                                apiResponse = addFurniture(data);
                            } catch (Exception e){
                                apiResponse =  new ApiResponse(STATUS_BAD_REQUEST,BAD_REQUEST);
                            }
                        }
                    }

                    case METHOD_PATCH -> {
                        if(reqBody==null || queryParams==null)
                            apiResponse =  new ApiResponse(STATUS_BAD_REQUEST,BAD_REQUEST);
                        else {
                            boolean format = true;
                            for (String field: fields)
                                format = format && reqBody.findValue(field)==null;
                            if(format){
                                apiResponse = new ApiResponse(STATUS_BAD_REQUEST, "No Field to Update");
                                break;
                            }
                            int id;
                            try {
                                id = Integer.parseInt(queryParams.get("id"));
                            } catch (Exception e) {
                                apiResponse = new ApiResponse(STATUS_BAD_REQUEST, DATA_NOT_INT);
                                break;
                            }
                            try{
                                FurnitureDto data = objectMapper.readValue(reqBody.toString(), FurnitureDto.class);
                                apiResponse = updateFurniture(id,data);
                            } catch (Exception e){
                                apiResponse =  new ApiResponse(STATUS_BAD_REQUEST,BAD_REQUEST);
                            }
                        }
                    }

                    case METHOD_DELETE -> {
                        if(queryParams!=null && queryParams.get("id")!=null){
                            try {
                                int id = Integer.parseInt(queryParams.get("id"));
                                apiResponse = deleteFurniture(id);
                            } catch (Exception e) {
                                apiResponse = new ApiResponse(STATUS_BAD_REQUEST, DATA_NOT_INT);
                            }
                        }
                        else
                            apiResponse =  new ApiResponse(STATUS_BAD_REQUEST,BAD_REQUEST);
                    }

                    default -> apiResponse = new ApiResponse(STATUS_METHOD_NOT_ALLOWED, METHOD_NOT_ALLOWED);
                }
                he.getResponseHeaders().set(HEADER_CONTENT_TYPE, HEADER_CHARSET);
                String responseBody = String.valueOf(Json.toJson(apiResponse));
                final byte[] rawResponseBody = responseBody.getBytes(CHARSET);
                he.sendResponseHeaders(apiResponse.getStatusCode(), rawResponseBody.length);
                he.getResponseBody().write(rawResponseBody);
            }
        }
    }
}

