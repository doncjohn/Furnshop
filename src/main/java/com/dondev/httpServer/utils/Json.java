package com.dondev.httpServer.utils;

import com.fasterxml.jackson.databind.*;

public class Json {
    private static ObjectMapper myObjectMapper = defaultObjectMapper();
    private static ObjectMapper defaultObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }
    public static JsonNode toJson(Object obj) {
        return myObjectMapper.valueToTree(obj);
    }

}