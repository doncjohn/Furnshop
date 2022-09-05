package com.dondev.httpServer.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.util.*;

public class Request {
    // Empty Constructor (Not Used)
    private Request(){}
    // Query Parameters
    public static Map<String, String> queryToMap(String query) {
        if(query == null) return null;
        Map<String, String> result = new HashMap<>();
        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 1) result.put(entry[0], entry[1]);
            else result.put(entry[0], "");
        }
        return result;
    }
    // Request Body Parameters
    public static JsonNode requestBody(HttpExchange he) throws IOException {
        Scanner scanner = new Scanner(he.getRequestBody()).useDelimiter("\\A");
        String value = scanner.hasNext() ? scanner.next() : "";
        return new ObjectMapper().readTree( value );
    }

}
