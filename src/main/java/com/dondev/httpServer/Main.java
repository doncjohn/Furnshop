package com.dondev.httpServer;

public class Main {
    public static final int PORT = 8081;
    public static void main(String[] args) {
        // Start Http Server
        SimpleHttpServer httpServer = new SimpleHttpServer();
        httpServer.start(PORT);
    }
}
