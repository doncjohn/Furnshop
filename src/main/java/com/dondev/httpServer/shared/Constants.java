package com.dondev.httpServer.shared;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class Constants {
    // Constructor Not Called
    private Constants() {}

    // Headers
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final Charset CHARSET = StandardCharsets.UTF_8;
    public static final String HEADER_CHARSET = String.format("application/json; charset=%s", CHARSET);

    // Status Codes
    public static final int STATUS_OK = 200;
    public static final int STATUS_CREATED = 201;
    public static final int STATUS_BAD_REQUEST = 400;
    public static final int STATUS_NOT_FOUND = 404;
    public static final int STATUS_METHOD_NOT_ALLOWED = 405;
    public static final int STATUS_ON_CONFLICT = 409;
    public static final int STATUS_INTERNAL_SERVER_ERROR = 500;

    // HTTP Methods
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PATCH = "PATCH";
    public static final String METHOD_DELETE = "DELETE";

    // Messages
    public static final String HEALTH_GOOD = "HEALTH GOOD";
    public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
    public static final String METHOD_NOT_ALLOWED = "Method not Allowed";
    public static final String BAD_REQUEST = "Bad Request";
    public static final String DATA_NOT_FOUND = "Data not Found";
    public static final String DATA_GOT = "Data retrieved successfully";
    public static final String DATA_INSERTED = "Data inserted successfully";
    public static final String DATA_INSERT_CONFLICT = "Data insertion conflict";
    public static final String DATA_UPDATED = "Data updated successfully";
    public static final String DATA_DELETED = "Data deleted successfully";
    public static final String DATA_NOT_INT = "Data entered is not Number";
}
