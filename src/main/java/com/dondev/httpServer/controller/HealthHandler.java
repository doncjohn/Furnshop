package com.dondev.httpServer.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import com.dondev.httpServer.model.ApiResponse;
import com.dondev.httpServer.utils.Json;
import static com.dondev.httpServer.shared.Constants.*;

import java.io.IOException;

public class HealthHandler {
    public static class RootHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {
            try (he) {
                final String requestMethod = he.getRequestMethod().toUpperCase();
                ApiResponse apiResponse;

                if (METHOD_GET.equals(requestMethod))
                    apiResponse = new ApiResponse(STATUS_OK, HEALTH_GOOD);
                else
                    apiResponse = new ApiResponse(STATUS_METHOD_NOT_ALLOWED, METHOD_NOT_ALLOWED);

                he.getResponseHeaders().set(HEADER_CONTENT_TYPE, HEADER_CHARSET);
                String responseBody = String.valueOf(Json.toJson(apiResponse));
                final byte[] rawResponseBody = responseBody.getBytes(CHARSET);
                he.sendResponseHeaders(apiResponse.getStatusCode(), rawResponseBody.length);
                he.getResponseBody().write(rawResponseBody);
            }
        }
    }
}
